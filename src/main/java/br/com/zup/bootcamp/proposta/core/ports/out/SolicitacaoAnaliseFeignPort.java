package br.com.zup.bootcamp.proposta.core.ports.out;

import br.com.zup.bootcamp.proposta.adapter.out.api.ResultadoAnalise;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import org.springframework.stereotype.Component;

@Component
public interface SolicitacaoAnaliseFeignPort {
    ResultadoAnalise solicitacao(Proposta proposta);
}
