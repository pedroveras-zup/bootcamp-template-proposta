package br.com.zup.bootcamp.proposta.core.ports;

import br.com.zup.bootcamp.proposta.adapter.out.api.ResultadoAnalise;
import br.com.zup.bootcamp.proposta.core.ports.domain.EligibilidadeProposta;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import br.com.zup.bootcamp.proposta.core.ports.domain.RespostaStatusAnalise;
import br.com.zup.bootcamp.proposta.core.ports.exception.ApiErroException;
import br.com.zup.bootcamp.proposta.core.ports.in.PropostaUseCase;
import br.com.zup.bootcamp.proposta.core.ports.out.PropostaPort;
import br.com.zup.bootcamp.proposta.core.ports.out.SolicitacaoAnaliseWebClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropostaService implements PropostaUseCase {

    private final PropostaPort propostaPort;
    private final SolicitacaoAnaliseWebClientPort solicitacaoAnaliseWebClientPort;

    public UUID novaProposta(Proposta proposta) {

        if (existeProposta(proposta)) {
            log.info("##### Proposta já existe #####");
            throw new ApiErroException(HttpStatus.UNPROCESSABLE_ENTITY, "Proposta já cadastrada");
        }

        UUID idProposta =  propostaPort.novaProposta(proposta);
//        proposta.setIdProposta(idProposta);

        EligibilidadeProposta eligibilidadeProposta =  statusProposta(proposta);
        proposta.setEligibilidadeProposta(eligibilidadeProposta);

        propostaPort.atualizaProposta(proposta);


        return idProposta;
    }

    private EligibilidadeProposta statusProposta(Proposta proposta) {
        ResultadoAnalise resultadoAnalise = solicitacaoAnaliseWebClientPort.solicitacao(proposta);
        return RespostaStatusAnalise.valueOf(resultadoAnalise.getResultadoSolicitacao()).getEligibilidadeProposta();
    }

    public boolean existeProposta(Proposta proposta) {
        return propostaPort.obtemProposta(proposta) != null;
    }

}
