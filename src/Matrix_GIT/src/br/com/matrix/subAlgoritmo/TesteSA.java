package br.com.matrix.subAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.OperadorBooleano.EntradaBooleana;
import br.com.matrix.subAlgoritmo.variavel.AtribuicaoVariavel;
import br.com.matrix.subAlgoritmo.variavel.AtribuicaoVetor;
import br.com.matrix.subAlgoritmo.variavel.ControladorVariavel;
import br.com.matrix.subAlgoritmo.variavel.ControladorVetor;
import br.com.matrix.subAlgoritmo.variavel.Variavel;
import br.com.matrix.subAlgoritmo.variavel.Vetor;

public class TesteSA {

    public static void main(String[] args) {
	ControladorVetor<Double> cv = new ControladorVetor<>();
	Vetor<Double> v = new Vetor<Double>(cv, Double.class);
	AtribuicaoVetor<Double> av = new AtribuicaoVetor<>(cv, Double.class);
    }

}
