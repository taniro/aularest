package br.rn.gov.sead.aularest.controller;

import br.rn.gov.sead.aularest.model.Cliente;
import br.rn.gov.sead.aularest.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService service;

    ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listALl(){
        return service.listAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> getOne(@PathVariable Long id){
        Optional<Cliente> cliente = service.findById(id);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cliente.get());
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente c){
        Cliente cliente = service.insert(c);
        return ResponseEntity.status(201).body(cliente);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente c){
        return service.findById(id)
                .map( record -> {
                    service.saveAndFlush(c);
                    return ResponseEntity.ok(c);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
