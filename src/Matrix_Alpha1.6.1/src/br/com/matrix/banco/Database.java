package br.com.matrix.banco;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.matrix.banco.tabelas.propTabelas.*;
import br.com.matrix.banco.tabelas.*;
import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.interfaces.ITabela;

public final class Database {

	public static Connection con = null;

	public static Statement stm = null;

	/**
	 * Faz conexão com o banco usando JDBC
	 */
	public static void conect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/matrix", "root", "");

			stm = con.createStatement();

			System.out.println("Conectado");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param tab
	 * @param cam
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
	 * @param colunas
	 *            - colunas
	 * @return select de SQL pronto para ser executado
	 */
	public static String selectBuilder(List<Coluna> colunas) {

		StringBuilder cmd = new StringBuilder("Select ");

		for (Coluna c : colunas) {

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
	 * @param Coluna
	 *            - c
	 * @return Se há ou não dependencias dentro do comando SQL
	 */
	public static boolean haveDependencia(Coluna c) {
		return !c.getTb().getDependecias().isEmpty();
	}

	/**
	 * 
	 * @param colunas
	 * @return constroi a parte de Inner Join do comando SQL
	 */
	public static String buildInner(List<Coluna> colunas) {

		List<ITabela> tbsInner = new ArrayList<>();
		List<ITabela> tbsNoInner = new ArrayList<>();
		StringBuilder inner = new StringBuilder();
		StringBuilder notInner = new StringBuilder();

		for (Coluna c : colunas) {
			if (!tbsNoInner.contains(c.getTb()))
				tbsNoInner.add(c.getTb());
		}

		for (Coluna coluna : colunas) {
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
		inner.append(appendCondicional(colunas, tbsInner, notInner));

		String result = notInner.toString() + (inner.toString().equals("") ? "" : ", ") + inner.toString();
		return result;

	}

	public static String appendCondicional(List<Coluna> colunas, List<ITabela> tbsInner, StringBuilder inner) {
		boolean b = false;
		for (Coluna c : colunas) {
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
	 * @param Coluna
	 *            - c
	 * @param StringBuilder
	 *            - cmd
	 * @return se existe ou não essa referência dentro do comando SQL
	 */
	public static boolean notInside(Coluna c, StringBuilder cmd) {
		return !cmd.toString().contains(c.getTb().getNm() + " " + c.getTb().getApelido());
	}

	/**
	 * 
	 * 
	 * 
	 * @param tabelas
	 * @param cmd
	 * @return cmd completo com os inner joins concatenados
	 */
	public static StringBuilder isInner(ArrayList<ITabela> tabelas, StringBuilder cmd) {
		if (tabelas.size() != 1) {

		}
		return cmd;
	}

	/**
	 * 
	 * @param cmd
	 * @return arraylist com "aparência" de uma tabela
	 */

	public static ArrayList<Linha> execute(String cmd) {

		if (con == null)
			conect();

		// Lista<Lista<NumeroLinha,Lista<NomeColuna,ValorColuna>>>
		ArrayList<Linha> linhas = new ArrayList<>();

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

						Coluna c = new Coluna(label, getTbNome(result, i));

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
			if (!con.isClosed()) {
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
	 * @param parameter
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
