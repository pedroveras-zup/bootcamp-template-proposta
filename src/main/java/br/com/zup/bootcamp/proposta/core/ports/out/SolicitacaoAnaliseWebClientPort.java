package br.com.zup.bootcamp.proposta.core.ports.out;

import br.com.zup.bootcamp.proposta.adapter.out.api.ResultadoAnalise;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;

public interface SolicitacaoAnaliseWebClientPort {
    ResultadoAnalise solicitacao(Proposta proposta);
}
