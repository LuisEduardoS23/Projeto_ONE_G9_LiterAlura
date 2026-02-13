package br.com.luisEduardo.literAlura.integration;

import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T converterDados(String json, Class<T> classe) {
        return mapper.readValue(json, classe);
    }
}
