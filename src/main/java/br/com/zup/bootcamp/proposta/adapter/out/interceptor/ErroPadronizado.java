package br.com.zup.bootcamp.proposta.adapter.out.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class ErroPadronizado {
    private Collection<String> mensagens;
}
