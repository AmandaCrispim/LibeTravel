package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Assento;
import br.edu.univille.poo.libetravel.entities.Passagem;
import br.edu.univille.poo.libetravel.entities.Voo;
import br.edu.univille.poo.libetravel.repositories.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    @Autowired
    private VooService vooService;

    @Autowired
    private AssentoService assentoService;

    public Passagem criarPassagem(Passagem passagem) {
        if (passagem.getVoos().isEmpty() || passagem.getVoos().size() > 2) {
            throw new RuntimeException("Uma passagem deve conter no mínimo 1 e no máximo 2 voos.");
        }

        if (passagem.getQuantidadePessoas() != passagem.getAssentos().size()) {
            throw new RuntimeException("A quantidade de assentos selecionados deve ser igual ao número de pessoas.");
        }

        double valorTotal = passagem.getVoos().stream()
                .mapToDouble(Voo::getValor)
                .sum();

        double valorAssentos = passagem.getAssentos().stream()
                .mapToDouble(Assento::getPreco)
                .sum();

        passagem.setValorFinal(valorTotal + valorAssentos);

        if (passagem.getDadosOcupantes().size() != passagem.getQuantidadePessoas()) {
            throw new RuntimeException("Dados de todos os ocupantes devem ser preenchidos.");
        }

        return passagemRepository.save(passagem);
    }
}

