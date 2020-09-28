package br.com.zup.bootcamp.proposta.core.ports.out;

import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;

import java.util.UUID;

public interface PropostaPort {

    UUID novaProposta(Proposta proposta);
    Proposta obtemProposta(Proposta proposta);
    Proposta atualizaProposta(Proposta proposta);
}
