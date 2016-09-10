package br.com.matrix.caixeiro;

import br.com.matrix.evo.suporte.CodigoGenEvo;

public class Coordenada {
	private Integer x;
	private Integer y;
	private Integer z;

	public Coordenada(Integer x, Integer y, Integer z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Integer getZ() {
		return z;
	}

	public Double getDist(Coordenada c) {
		return getDist(this, c);
	}

	public static Double getDist(Coordenada c, Coordenada d) {
		Double r = Math.sqrt(Math.pow(c.getX() - d.getX(), 2) + Math.pow(c.getY() - d.getY(), 2));
		r = Math.sqrt(Math.pow(r, 2) + Math.pow(c.getZ() - d.getZ(), 2));
		return r;
	}

	public static CodigoGenEvo<Coordenada> getMap() {
		CodigoGenEvo<Coordenada> r = new CodigoGenEvo<Coordenada>();

		r.add(new Coordenada(1, 1, 1));
		r.add(new Coordenada(1, 1, 2));
		r.add(new Coordenada(1, 2, 2));
		r.add(new Coordenada(2, 2, 2));
		r.add(new Coordenada(2, 2, 1));
		r.add(new Coordenada(2, 1, 1));
		r.add(new Coordenada(2, 0, 1));
		r.add(new Coordenada(10, -1, 1));
		r.add(new Coordenada(7, 0, 4));
		r.add(new Coordenada(9, 6, 3));
		r.add(new Coordenada(0, 1, 2));
		r.add(new Coordenada(2, 3, 1));
		r.add(new Coordenada(4, 4, 2));
		r.add(new Coordenada(0, 0, 1));
		r.add(new Coordenada(5, 6, 1));
		r.add(new Coordenada(4, 6, 2));
		r.add(new Coordenada(10, 10, 10));
		r.add(new Coordenada(0, 0, 0));

		return r;
	}

	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}

	public String toString() {
		return "(" + getX() + "," + getY() + "," + getZ() + ")";
	}
}
