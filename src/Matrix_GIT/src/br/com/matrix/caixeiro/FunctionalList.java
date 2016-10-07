package br.com.matrix.caixeiro;

import java.util.Comparator;
import java.util.List;

public interface FunctionalList<E> extends List<E> {

        
        public default void sort(Comparator<? super E> comp, int ini, int fin){
    		List<E> a, b, c;
    		a = this.subList(0, ini-1);
    		b = this.subList(ini, fin);
    		c = this.subList(fin+1, this.size()-1);
    		b.sort(comp);
    		this.clear();
    		this.addAll(a);
    		this.addAll(b);
    		this.addAll(c);
         }

}
