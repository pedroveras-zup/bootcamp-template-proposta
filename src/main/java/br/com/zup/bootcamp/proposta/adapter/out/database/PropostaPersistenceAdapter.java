package br.com.zup.bootcamp.proposta.adapter.out.database;

import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import br.com.zup.bootcamp.proposta.core.ports.out.PropostaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PropostaPersistenceAdapter implements PropostaPort {
    private final PropostaRepository propostaRepository;

    @Override
    public UUID novaProposta(Proposta proposta) {
        PropostaEntity propostaEntity = PropostaEntity.builder().id(UUID.randomUUID()).documento(proposta.getDocumento())
                .email(proposta.getEmail()).endereco(proposta.getEndereco()).nome(proposta.getNome())
                .salario(proposta.getSalario()).build();

        PropostaEntity propostaSalva = propostaRepository.save(propostaEntity);

        return propostaSalva.getId();
    }

    @Override
    public Proposta obtemProposta(Proposta proposta) {
        PropostaEntity propostaEntity = propostaRepository.findByDocumento(proposta.getDocumento());

       return propostaEntity == null? null :
                Proposta.builder().documento(propostaEntity.getDocumento()).nome(propostaEntity.getNome())
                .email(propostaEntity.getEmail()).endereco(propostaEntity.getEndereco())
                .salario(propostaEntity.getSalario()).build();
    }

    public Proposta atualizaProposta(Proposta proposta) {
        PropostaEntity propostaEntity = PropostaEntity.builder().id(UUID.randomUUID()).documento(proposta.getDocumento())
                .email(proposta.getEmail()).endereco(proposta.getEndereco()).nome(proposta.getNome())
                .salario(proposta.getSalario()).eligibilidadeProposta(proposta.getEligibilidadeProposta()).build();


        PropostaEntity propostaEntityResult = propostaRepository.save(propostaEntity);

        return propostaEntityResult == null? null :
                Proposta.builder().documento(propostaEntity.getDocumento()).nome(propostaEntity.getNome())
                        .email(propostaEntity.getEmail()).endereco(propostaEntity.getEndereco())
                        .salario(propostaEntity.getSalario()).build();
    }
}
