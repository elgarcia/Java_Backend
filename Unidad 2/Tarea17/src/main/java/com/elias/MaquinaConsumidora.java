package com.elias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class MaquinaConsumidora {
    private List<Integer>                   numbers;
    private Predicate<Integer>              filter;
    private Function<List<Integer>, Long>   calc;

    public MaquinaConsumidora(List<Integer> list, Predicate<Integer> filter, Function<List<Integer>, Long> consumir){
        this.calc = consumir;
        this.numbers = list;
        this.filter = filter;
    }

    public long consumir(){
        List<Integer> nb = new ArrayList<>(this.numbers);

        nb.removeIf(this.filter.negate());
        return (this.calc.apply(nb));
    }
}

class MayorImpar extends MaquinaConsumidora{
    public MayorImpar(List<Integer> list) {
        super(list, n -> n % 2 != 0, lista -> Collections.max(lista).longValue());
    }
}
