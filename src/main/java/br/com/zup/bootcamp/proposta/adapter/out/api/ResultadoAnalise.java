package br.com.zup.bootcamp.proposta.adapter.out.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultadoAnalise {
    @JsonProperty("documento")
    private String documento;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("resultadoSolicitacao")
    private String resultadoSolicitacao;
    @JsonProperty("idProposta")
    private String idProposta;
}
