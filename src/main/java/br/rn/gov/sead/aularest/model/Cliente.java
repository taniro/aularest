package br.rn.gov.sead.aularest.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_clientes") //especifica que essa classe será anotada como uma tabela do banco
@AllArgsConstructor //cria construtor com todos os atributos
@NoArgsConstructor //cria construtor sem argumentos
@Data //cria métodos getters, setters, hashCode e equals
public class Cliente {
    @Id //especifica o atributo como ID da tabela
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    //@Column(name = "nome_cliente", length = 50, nullable = false)
    String nome;
    /*
    int idade;
    Date nascimento;

    Date deleted;
     */
}