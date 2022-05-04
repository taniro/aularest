package br.rn.gov.sead.aularest.repository;

import br.rn.gov.sead.aularest.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findAllByNome(String nome);
    public Cliente deleteByNome(String nome);
}
