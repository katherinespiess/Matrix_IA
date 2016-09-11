package br.com.matrix.banco.tabelas.classesAbstratas;

public abstract class AControleTabelas {

	private boolean datas = false;

	private boolean estruturas = false;

	private boolean frases = false;

	private boolean palavras = false;

	private boolean pontuacoes = false;

	private boolean textos = false;
	
	private boolean sugestores_has_palavras = false;

	private boolean sugestores_has_estruturas = false;

	private boolean textos_has_datas = false;

	private boolean textos_has_frases = false;

	private boolean frases_has_estruturas = false;	

	public boolean isDatas() {
		return datas;
	}

	public void setDatas() {
		this.datas = !this.datas;
	}

	public boolean isEstruturas() {
		return estruturas;
	}

	public void setEstruturas() {
		this.estruturas = !this.estruturas;
	}


	public boolean isFrases() {
		return frases;
	}

	public void setFrases() {
		this.frases = !this.frases;
	}

	public boolean isPalavras() {
		return palavras;
	}

	public void setPalavras( ) {
		this.palavras = !this.palavras;
	}

	public boolean isPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes() {
		this.pontuacoes = !this.pontuacoes;
	}

	public boolean isSugestores_has_palavras() {
		return sugestores_has_palavras;
	}

	public void setSugestores_has_palavras() {
		this.sugestores_has_palavras = !this.sugestores_has_palavras;
	}

	public boolean isSugestores_has_estruturas() {
		return sugestores_has_estruturas;
	}

	public void setSugestores_has_estruturas() {
		this.sugestores_has_estruturas = !this.sugestores_has_estruturas;
	}

	public boolean isTextos_has_datas() {
		return textos_has_datas;
	}

	public void setTextos_has_datas() {
		this.textos_has_datas = !this.textos_has_datas;
	}

	public boolean isFrases_has_estruturas() {
		return frases_has_estruturas;
	}

	public void setFrases_has_estruturas() {
		this.frases_has_estruturas = !this.frases_has_estruturas;
	}

	public boolean isTextos_has_frases() {
		return textos_has_frases;
	}

	public void setTextos_has_frases() {
		this.textos_has_frases = !this.textos_has_frases;
	}

	public boolean isTextos() {
		return textos;
	}

	public void setTextos() {
		this.textos = !this.textos;
	}

}
