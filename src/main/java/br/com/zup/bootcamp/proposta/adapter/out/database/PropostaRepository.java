package br.com.zup.bootcamp.proposta.adapter.out.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, String> {

    PropostaEntity findByDocumento(String documento);
}
