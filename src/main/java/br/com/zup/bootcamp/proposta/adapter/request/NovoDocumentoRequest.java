package br.com.zup.bootcamp.proposta.adapter.request;

import br.com.zup.bootcamp.proposta.adapter.request.validacao.annotation.CpfCnpj;
import br.com.zup.bootcamp.proposta.core.ports.domain.Proposta;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoDocumentoRequest {
    @CpfCnpj
    private String documento;

    public NovoDocumentoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
    }
}
