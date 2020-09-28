package br.com.zup.bootcamp.proposta.adapter.out.api.rest.feign;

import br.com.zup.bootcamp.proposta.adapter.out.api.ResultadoAnalise;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import br.com.zup.bootcamp.proposta.core.ports.out.SolicitacaoAnaliseFeignPort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "solicitacao", url = "http://localhost:9999/api")
public interface SolicitacaoAnaliseFeign extends SolicitacaoAnaliseFeignPort {

    @RequestMapping(method = RequestMethod.POST, value = "/solicitacao")
    ResultadoAnalise solicitacao(@RequestBody Proposta proposta);
}
