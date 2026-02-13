package br.com.luisEduardo.literAlura.integration;

import tools.jackson.databind.ObjectMapper;


public interface IConverteDados{

    public <T> T converterDados(String json, Class<T> classe);
}
