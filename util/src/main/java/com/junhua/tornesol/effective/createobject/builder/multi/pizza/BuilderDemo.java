package com.junhua.tornesol.effective.createobject.builder.multi.pizza;

import static com.junhua.tornesol.effective.createobject.builder.multi.pizza.NyPizza.Size.SMALL;
import static com.junhua.tornesol.effective.createobject.builder.multi.pizza.Pizza.Topping.*;

public class BuilderDemo {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        return;


    }


}
