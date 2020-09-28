package br.com.zup.bootcamp.proposta.adapter.out.database;

import br.com.zup.bootcamp.proposta.core.ports.domain.EligibilidadeProposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Proposta")
public class PropostaEntity {

    @Id
    private UUID id;
    @Column
    private String documento;
    @Column
    private String email;
    @Column
    private String nome;
    @Column
    private String endereco;
    @Column
    private BigDecimal salario;
    @Column
    private EligibilidadeProposta eligibilidadeProposta;

}