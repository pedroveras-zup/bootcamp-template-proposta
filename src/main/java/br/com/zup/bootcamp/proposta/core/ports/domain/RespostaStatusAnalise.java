package br.com.zup.bootcamp.proposta.core.ports.domain;

public enum RespostaStatusAnalise {
    COM_RESTRICAO(EligibilidadeProposta.NAO_ELEGIVEL),SEM_RESTRICAO(EligibilidadeProposta.ELEGIVEL);

    private EligibilidadeProposta eligibilidadeProposta;

    RespostaStatusAnalise(EligibilidadeProposta eligibilidadeProposta) {
        this.eligibilidadeProposta = eligibilidadeProposta;
    }

    public EligibilidadeProposta getEligibilidadeProposta() {
        return eligibilidadeProposta;
    }
}
