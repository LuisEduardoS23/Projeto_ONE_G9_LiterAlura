package br.com.luisEduardo.literAlura.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroApiResponse (@JsonAlias("title") String titulo,
                                @JsonAlias("authors") List<AutorApiResponse> autor,
                                @JsonAlias("languages") List<String> idioma,
                                @JsonAlias("download_count") Long numeroDownloads) {


}
