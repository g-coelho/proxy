package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Fita> fitas = new HashMap<>();

    public static Fita getFita(Integer registro) {
        return fitas.get(registro);
    }

    public static void addFita(Fita fita) {
        fitas.put(fita.getRegistro(), fita);
    }
}
