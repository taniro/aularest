package br.rn.gov.sead.aularest.service;


import br.rn.gov.sead.aularest.model.Cliente;
import br.rn.gov.sead.aularest.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    ClienteRepository repository;

    ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public Cliente insert(Cliente c){
        return repository.save(c);
    }

    public Cliente update(Cliente c){
        return repository.save(c);
    }

    public void delete (Cliente c){
        repository.delete(c);
    }

    public Cliente saveAndFlush(Cliente c){
        return repository.saveAndFlush(c);
    }

    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

    public List<Cliente> listAll(){
        return repository.findAll();
    }
}
