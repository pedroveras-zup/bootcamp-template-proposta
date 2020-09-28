package br.com.zup.bootcamp.proposta.adapter.out.api.rest.webclient;

import br.com.zup.bootcamp.proposta.adapter.out.api.ResultadoAnalise;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import br.com.zup.bootcamp.proposta.core.ports.out.SolicitacaoAnaliseWebClientPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SolicitacaoAnaliseWebClientComponent implements SolicitacaoAnaliseWebClientPort {

    private static final String SOLICITACAO = "/solicitacao";

    @Value("${solicitacao.url}")
    private String url;

    @Override
    public ResultadoAnalise solicitacao(Proposta proposta) {
        WebClient client = WebClient.create();
        return client.post().uri(url.concat(SOLICITACAO)).body(Mono.just(proposta), Proposta.class).retrieve()
                        .bodyToMono(ResultadoAnalise.class).block();
    }
}
