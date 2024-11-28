package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private Double valor;
    private String companhiaAerea;

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    @ManyToOne
    @JoinColumn(name = "aeroporto_embarque_id")
    private Aeroporto aeroportoEmbarque;

    @ManyToOne
    @JoinColumn(name = "aeroporto_desembarque_id")
    private Aeroporto aeroportoDesembarque;

    @ManyToMany(mappedBy = "voos")
    private List<Passagem> passagens;

    public Voo(Long id, String origem, String destino, LocalDateTime dataHora, Double valor, String companhiaAerea, Aeronave aeronave, Aeroporto aeroportoEmbarque, Aeroporto aeroportoDesembarque) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.valor = valor;
        this.companhiaAerea = companhiaAerea;
        this.aeronave = aeronave;
        this.aeroportoEmbarque = aeroportoEmbarque;
        this.aeroportoDesembarque = aeroportoDesembarque;
    }
}
