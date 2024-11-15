package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador; // Fileiras da esquerda: ABC, fileiras da direita EFG, todas possuem 10 assentos cada. A01, A02...
    private Double preco; // Valor do assento, janelas (A e G) são os mais caros, meio (B e F) os mais baratos e os dos corredores (C e E) o meio termo.

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;
}
