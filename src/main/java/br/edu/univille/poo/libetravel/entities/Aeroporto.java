package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String estado;
    private String pais;

    @ManyToMany(mappedBy = "aeroportos")
    private List<Aeronave> aeronaves;

    @OneToMany(mappedBy = "aeroportoEmbarque")
    private List<Voo> voosDeEmbarque;

    @OneToMany(mappedBy = "aeroportoDesembarque")
    private List<Voo> voosDeDesembarque;
}