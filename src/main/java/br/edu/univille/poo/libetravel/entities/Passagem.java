package br.edu.univille.poo.libetravel.entities;

// (valor do voo + valor do assento = valor total da passagem)

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "passagem_voo",
            joinColumns = @JoinColumn(name = "passagem_id"),
            inverseJoinColumns = @JoinColumn(name = "voo_id")
    )
    private List<Voo> voos;

    @ManyToMany
    @JoinTable(
            name = "passagem_assento",
            joinColumns = @JoinColumn(name = "passagem_id"),
            inverseJoinColumns = @JoinColumn(name = "assento_id")
    )
    private List<Assento> assentos;

    @OneToOne
    @JoinColumn(name = "dados_passageiro_id", nullable = false)
    private DadosPassageiros dadosPassageiro;

    private Double valorFinal;
}

