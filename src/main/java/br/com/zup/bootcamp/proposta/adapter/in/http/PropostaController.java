package br.com.zup.bootcamp.proposta.adapter.in.http;

import br.com.zup.bootcamp.proposta.adapter.request.NovaPropostaRequest;
import br.com.zup.bootcamp.proposta.core.ports.in.PropostaUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PropostaController {

    private final PropostaUseCase propostaUseCase;

    @PostMapping
    public ResponseEntity<?> novaProposta(@RequestBody @Valid NovaPropostaRequest novaPropostaRequest,
                                          UriComponentsBuilder builder) {

        log.info("Nova proposta será criada");

        UUID idProposta = propostaUseCase.novaProposta(novaPropostaRequest.toModel());
//        ResultadoAnalise resultadoAnalise = propostaUseCase.statusProposta(novaPropostaRequest);

        URI endereco = builder.path("/{id}").build(idProposta);

        log.info("Proposta id={} criada com sucesso!", idProposta);

        return ResponseEntity.created(endereco).body(idProposta);
    }


}
