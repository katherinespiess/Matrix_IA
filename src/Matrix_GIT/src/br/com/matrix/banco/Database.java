package br.com.matrix.banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import br.com.matrix.banco.tabelas.Datas;
import br.com.matrix.banco.tabelas.Estruturas;
import br.com.matrix.banco.tabelas.Frases;
import br.com.matrix.banco.tabelas.Frases_has_Palavras;
import br.com.matrix.banco.tabelas.Palavras;
import br.com.matrix.banco.tabelas.Pontuacoes;
import br.com.matrix.banco.tabelas.Sugestores;
import br.com.matrix.banco.tabelas.Sugestores_has_Estruturas;
import br.com.matrix.banco.tabelas.Sugestores_has_Sugestores;
import br.com.matrix.banco.tabelas.Textos;
import br.com.matrix.banco.tabelas.Textos_has_Datas;
import br.com.matrix.banco.tabelas.Textos_has_Frases;
import br.com.matrix.banco.tabelas.Tipo_Estruturas;
import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.banco.tabelas.interfaces.ITabela;
import br.com.matrix.banco.tabelas.propTabelas.Campo;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
import br.com.matrix.banco.tabelas.propTabelas.Linha;
import br.com.matrix.getClasses.GetClasses;

public final class Database {

	public static Connection con = null;

	public static Statement stm = null;

	/**
	 * Faz conexão com o banco usando JDBC
	 */
	public static void conect() {

		try {

			Class<?> driverClass = Class.forName("com.mysql.jdbc.Driver");
			Driver driver = (Driver) driverClass.newInstance();
			DriverManager.registerDriver(driver);

			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/matrix", "root", "");

			stm = con.createStatement();

			System.out.println("Conectado");

			/*
			 * Class driver_class = Class.forName(driver); Driver driver =
			 * (Driver) driver_class.newInstance();
			 * DriverManager.registerDriver(driver); connection =
			 * DriverManager.getConnection(url + dbName);
			 */

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static <T> T[] concatArray(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);

		System.arraycopy(second, 0, result, first.length, second.length);

		return result;
	}

	static <T> T[] append(T[] arr, T element) {
		final int N = arr.length;
		arr = Arrays.copyOf(arr, N + 1);
		arr[N] = element;
		return arr;
	}

	public static int getIdByName(String table, String field, String name) throws SQLException {
		ResultSet set = stm.executeQuery("select id from " + table + " where " + field + " = " + name);

		if (set.next())
			return Integer.parseInt(set.getString("id"));

		return 0;

	}

	//TODO
	public static void stringSplitUpdate(String term) throws SQLException {
		if (con.isClosed() || con == null)
			conect();

		List<String> frases = new ArrayList<>(Arrays.asList(concatArray(term.split("."), term.split(","))));
		String[] palavras = term.split("\\s+");
		String[] pontuacoes = term.split("[\\w\\s+]");

		List<Integer> palavrasIds = new ArrayList<>();
		List<Integer> frasesIds = new ArrayList<>();
		List<Integer> pontuacoesIds = new ArrayList<>();

		for (String palavra : palavras)
			if (!stringExists("Palavras", palavra))
				palavrasIds.add(simpleInsert("Palavras", new Object[] { palavra }));

		for (String palavra : palavras)
			if (Arrays.asList(frases).contains(palavra)) {
				frasesIds.add(simpleInsert("Frases", new Object[] { 1 }));
			}
		for (String pontuacao : pontuacoes)
			if (!stringExists("Pontuacoes", pontuacao))
				pontuacoesIds.add(simpleInsert("Pontuacoes", new Object[] { pontuacao }));

	}

	public static int simpleInsert(String table, Object[] values) throws SQLException {

		Function<Object[], String[]> formatArray = v -> {

			String[] ret = new String[v.length];

			for (Object o : v)
				append(ret, formatParameter(o));

			return ret;
		};
		
		String valores = String.join(",", formatArray.apply(values)).replaceAll("[,]+$", "");

		return stm.executeUpdate("INSERT INTO " + table + " VALUES(" + valores + ")", Statement.RETURN_GENERATED_KEYS);
	}

	public static boolean isStringInDb(String term) throws SQLException {
		if (con == null)
			conect();

		List<String> tables = GetClasses.getClassNamesByPackage("br.com.matrix.banco.tabelas", (new String[0]));
		for (String table : tables)
			if (stringExists(table, term))
				return true;

		return false;
	}

	public static boolean isStringInDb(String term, ArrayList<String> exclude) throws SQLException {
		if (con == null)
			conect();

		List<String> tables = GetClasses.getClassNamesByPackage("br.com.matrix.banco.tabelas",
				exclude.toArray(new String[10]));
		for (String table : tables)
			if (stringExists(table, term))
				return true;

		return false;
	}

	private static boolean stringExists(String table, String term) throws SQLException {
		if (con == null)
			conect();

		ResultSet set = stm.executeQuery("select * from " + table + " where ds like " + term);
		return set.next();
	}

	/**
	 * 
	 * @paramReq tab
	 * @paramReq cam
	 * @return se houver erros retorna false senão true - Formata valores dos
	 *         campos e os insere no banco
	 */
	public static boolean insert(ArrayList<ATabela> tab, ArrayList<Campo> cam) {

		StringBuilder cmd = new StringBuilder();

		List<String> cf = new ArrayList<>(); // colunas formatadas

		// Formata os valores antes da inserção
		for (Campo c : cam) {
			cf.add(formatParameter(c.getValor()));
		}
		try {
			for (ATabela t : tab) {

				cmd.append("Insert into " + t.getNm() + " values( ");

				int i = 0;

				for (Campo c : cam) {
					if (t.getColunas().contains(c.getColuna())) {

						int index = cf.indexOf(formatParameter(c.getValor()));

						cmd.append((i != 0) ? ", " : "");

						cmd.append(cf.get(index));

						i++;
					}
				}
				cmd.append(");");

				if (con == null)
					conect();

				stm = con.createStatement();

				i = stm.executeUpdate(cmd.toString());
				// pode ser usado o método execute query também

				System.out.println(cmd.toString());
				System.out.println("Nº de campos afetados: " + i);

				resetCon();
			}
			return true;

		} catch (SQLException e) {
			return false;
		}

	}

	/**
	 * 
	 * @paramReq colunas - colunas
	 * @return select de SQL pronto para ser executado
	 */
	public static String selectBuilder(List<GenColuna> colunas) {

		StringBuilder cmd = new StringBuilder("Select ");

		for (GenColuna c : colunas) {

			if (colunas.indexOf(c) > 0)
				cmd.append(",");

			cmd.append(c.getTb().getApelido() + "." + c.getNm());
		}

		cmd.append(" from ");

		cmd.append(buildInner(colunas));

		return cmd.toString();
	}

	/**
	 * 
	 * @paramReq Coluna - c
	 * @return Se há ou não dependencias dentro do comando SQL
	 */
	public static boolean haveDependencia(GenColuna c) {
		return !c.getTb().getDependecias().isEmpty();
	}

	/**
	 * 
	 * @paramReq colunas
	 * @return constroi a parte de Inner Join do comando SQL
	 */
	public static String buildInner(List<GenColuna> colunas) {

		List<ITabela> tbsInner = new ArrayList<>();
		List<ITabela> tbsNoInner = new ArrayList<>();
		StringBuilder inner = new StringBuilder();
		StringBuilder notInner = new StringBuilder();

		for (GenColuna c : colunas) {
			if (!tbsNoInner.contains(c.getTb()))
				tbsNoInner.add(c.getTb());
		}

		for (GenColuna coluna : colunas) {
			if (coluna instanceof ColunaFk) {

				ColunaFk cfk = (ColunaFk) coluna;

				if ((tbsNoInner.contains(cfk.getColunaRef().getTb()) || tbsInner.contains(cfk.getColunaRef().getTb()))
						&& (tbsNoInner.contains(cfk.getTb()) || tbsInner.contains(cfk.getTb()))) {

					tbsInner.remove(cfk.getColunaRef().getTb());
					tbsInner.remove(cfk.getTb());

					tbsInner.add(cfk.getColunaRef().getTb());
					tbsInner.add(cfk.getTb());

					tbsNoInner.remove(cfk.getColunaRef().getTb());
					tbsNoInner.remove(cfk.getTb());

				}

			}
		}

		for (ITabela t : tbsNoInner) {
			if (tbsNoInner.indexOf(t) > 0)
				notInner.append(", ");
			notInner.append(t.getNm() + " " + t.getApelido());
		}
		inner.append(appendCondicional(colunas, tbsInner, inner));

		String result = notInner.toString() + (inner.toString().equals("") ? "" : ", ") + inner.toString();
		return result;

	}

	public static String appendCondicional(List<GenColuna> colunas, List<ITabela> tbsInner, StringBuilder inner) {
		boolean b = false;
		for (GenColuna c : colunas) {
			if (c instanceof ColunaFk && tbsInner.contains(((ColunaFk) c).getColunaRef().getTb())) {
				ColunaFk fk = (ColunaFk) c;
				tbsInner.remove(fk.getColunaRef().getTb());
				ITabela t = fk.getColunaRef().getTb();
				if (b)
					inner.append(" inner join ");
				inner.append(t.getNm() + " " + t.getApelido());
				if (b)
					inner.append(" on " + fk.getApNm() + " = " + fk.getColunaRef().getApNm());
				b = true;
			}
			if (c instanceof ColunaFk && tbsInner.contains(c.getTb())) {
				ColunaFk fk = (ColunaFk) c;
				tbsInner.remove(fk.getTb());
				ITabela t = fk.getTb();
				if (b)
					inner.append(" inner join ");
				inner.append(t.getNm() + " " + t.getApelido());
				if (b)
					inner.append(" on " + fk.getApNm() + " = " + fk.getColunaRef().getApNm());
				b = true;
			}
		}
		return inner.toString();
	}

	/**
	 * 
	 * @paramReq Coluna - c
	 * @paramReq StringBuilder - cmd
	 * @return se existe ou não essa referência dentro do comando SQL
	 */
	public static boolean notInside(GenColuna c, StringBuilder cmd) {
		return !cmd.toString().contains(c.getTb().getNm() + " " + c.getTb().getApelido());
	}

	/**
	 * 
	 * 
	 * 
	 * @paramReq tabelas
	 * @paramReq cmd
	 * @return cmd completo com os inner joins concatenados
	 */
	public static StringBuilder isInner(ArrayList<ITabela> tabelas, StringBuilder cmd) {
		if (tabelas.size() != 1) {

		}
		return cmd;
	}

	/**
	 * 
	 * @paramReq cmd
	 * @return arraylist com "aparência" de uma tabela
	 */

	public static List<ILinha> execute(String cmd) {

		try {
			if (con == null || con.isClosed())
				conect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Lista<Lista<NumeroLinha,Lista<NomeColuna,ValorColuna>>>
		List<ILinha> linhas = new ArrayList<>();

		try {

			ResultSet result = null;

			result = stm.executeQuery(cmd);

			int i = 0;

			if (result != null) {

				while (result.next()) {

					i++;

					System.out.println("executando: " + cmd + "  ...");

					Linha li = new Linha();

					// Uma lista de coluna para cada linha

					for (int j = 1; j <= result.getMetaData().getColumnCount(); j++) {

						// pega o tipo da coluna
						int type = result.getMetaData().getColumnType(j);

						String label = (result.getMetaData().getColumnLabel(j) != null)
								? result.getMetaData().getColumnLabel(j) : "null";

						GenColuna c = new GenColuna(label, getTbNome(result, i));

						Campo cp = null;

						// compara o tipo pego com um ENUM
						if (type == Types.VARCHAR)
							cp = new Campo(c, result.getString(j));

						else if (type == Types.DECIMAL)
							cp = new Campo(c, result.getDouble(j));

						else if (type == Types.BOOLEAN || type == Types.BIT || type == Types.BINARY)
							cp = new Campo(c, result.getBoolean(j));

						else if (type == Types.INTEGER)
							cp = new Campo(c, result.getInt(j));

						else if (type == Types.DATE)
							cp = new Campo(c, result.getDate(j));

						else if (type == Types.TIMESTAMP)
							cp = new Campo(c, result.getTimestamp(j));

						else if (type == Types.NULL)
							cp = new Campo(c, null);
						else {
							System.out.println("O camando foi parado pois no banco há valores incompativeis");
							System.out.println("Resultado: nº " + i);
							System.out.println("Coluna :" + label);
						}

						li.getCampos().add(cp);// Adiciona na linha

					}

					linhas.add(li);

				}
				System.out.println("Sucesso!!!");
				System.out.println(i + " resultado(s)!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resetCon();
		}

		return linhas;

	}

	public static void resetCon() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;

	}

	public static ATabela getTbNome(ResultSet rs, int i) {
		try {

			if (rs.getMetaData().getTableName(i).toLowerCase().contains("o_estruturas"))
				return Tipo_Estruturas.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("_estruturas"))
				return Sugestores_has_Estruturas.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("estruturas"))
				return Estruturas.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("has_palavras"))
				return Frases_has_Palavras.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("palavras"))
				return Palavras.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("palavras"))
				return Palavras.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("has_datas"))
				return Textos_has_Datas.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("data"))
				return Datas.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("frases_has"))
				return Frases_has_Palavras.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("has_frases"))
				return Textos_has_Frases.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("frases"))
				return Frases.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("pontua"))
				return Pontuacoes.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("_sugestores"))
				return Sugestores_has_Sugestores.get();

			else if (rs.getMetaData().getTableName(i).toLowerCase().contains("sugestores"))
				return Sugestores.get();

			else
				return Textos.get();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * @paramReq parameter
	 * @return parametro Formatado ou em forma de string
	 * 
	 *         Obs Formata os parametros para um inserção adequada no banco de
	 *         dados
	 */
	public static String formatParameter(Object parameter) {

		if (parameter == null)
			return "NULL";
		else {
			if (parameter instanceof String)
				return "'" + ((String) parameter).replace("'", "''") + "'";

			else if (parameter instanceof Timestamp)
				return "to_timestamp('" + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS").format(parameter)
						+ "', 'mm/dd/yyyy hh24:mi:ss.ff3')";

			else if (parameter instanceof Date)
				return "to_date('" + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(parameter)
						+ "', 'mm/dd/yyyy hh24:mi:ss')";

			else if (parameter instanceof Boolean)
				return ((Boolean) parameter).booleanValue() ? "1" : "0";

			else
				return parameter.toString();

		}
	}

}
