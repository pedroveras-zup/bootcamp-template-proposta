package br.com.zup.bootcamp.proposta.core.ports.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proposta {

    private UUID idProposta;
    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;
    private EligibilidadeProposta eligibilidadeProposta;
}
