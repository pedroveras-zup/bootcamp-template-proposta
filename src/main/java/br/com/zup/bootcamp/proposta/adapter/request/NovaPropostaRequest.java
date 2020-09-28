package br.com.zup.bootcamp.proposta.adapter.request;

import br.com.zup.bootcamp.proposta.adapter.request.validacao.annotation.CpfCnpj;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class NovaPropostaRequest {

    @CpfCnpj(required = true)
    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;

    public Proposta toModel() {
        return Proposta.builder().documento(documento).nome(nome).email(email)
                .endereco(endereco).salario(salario).build();
    }
}
