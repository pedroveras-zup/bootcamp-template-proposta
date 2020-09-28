package br.com.zup.bootcamp.proposta.core.ports.in;

import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;

import java.util.UUID;

public interface PropostaUseCase {
    UUID novaProposta(Proposta novaPropostaRequest);
//    ResultadoAnalise statusProposta(NovaPropostaRequest novaPropostaRequest);
}
