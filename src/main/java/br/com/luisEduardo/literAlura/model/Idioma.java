package br.com.luisEduardo.literAlura.model;

import java.util.Arrays;

public enum Idioma {
    en("en"),
    es("es"),
    fr("fr"),
    pt("pt");

    private String codigo;

    Idioma(String idioma) {
        this.codigo = idioma;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Idioma fromCodigo(String codigo) {
        return Arrays.stream(Idioma.values())
                .filter(i -> i.codigo.equalsIgnoreCase(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Idioma inválido"));
    }
}
