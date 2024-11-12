package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//o voo contem dados como data de ida e volta, aeroporto,companhia aerea e valor
@Data
@Entity
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String data;
    public String hora;
    public String aerporto;
    public String companhiaArea;
    //aeroporto de embarque: Aeroporto
    //aeroporto de desembarque: Aeroporto

    @ManyToMany(mappedBy = "voos")
    private Set<Passagem> passagens;
}
