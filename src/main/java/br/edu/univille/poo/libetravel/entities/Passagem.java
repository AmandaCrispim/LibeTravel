package br.edu.univille.poo.libetravel.entities;

// (valor do voo + valor do assento = valor total da passagem)

import jakarta.persistence.*;

@Entity
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public int qntdAssentos;


    @ManyToMany
    @JoinTable(
            name = "passagem_voo",
            joinColumns = @JoinColumn(name = "passagem_id"),
            inverseJoinColumns = @JoinColumn(name = "voo_id")
}
