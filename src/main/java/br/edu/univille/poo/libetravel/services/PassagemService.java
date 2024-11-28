package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Passagem;
import br.edu.univille.poo.libetravel.entities.Voo;
import br.edu.univille.poo.libetravel.repositories.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository passagemRepository;

    @Autowired
    private VooService vooService;

    @Autowired
    private AssentoService assentoService;

    public double calcularValorTotal(Passagem passagem) {
        double valorTotal = passagem.getVoos().stream()
                .mapToDouble(Voo::getValor)
                .sum();

        double valorAssento = passagem.getAssentos().get(0).getPreco();

        return valorTotal + valorAssento;
    }

    public List<Passagem> criarPassagens(List<Passagem> passagens) {
        List<Passagem> passagensCriadas = new ArrayList<>();

        for (Passagem passagem : passagens) {
            if (passagem.getVoos().isEmpty() || passagem.getVoos().size() > 2) {
                throw new RuntimeException("Uma passagem deve conter no mínimo 1 e no máximo 2 voos.");
            }

            if (passagem.getAssentos().size() != 1) {
                throw new RuntimeException("Cada passagem deve conter apenas um assento.");
            }

            if (passagem.getDadosPassageiro() == null) {
                throw new RuntimeException("Dados do passageiro devem ser preenchidos.");
            }

            double valorTotal = calcularValorTotal(passagem);

            passagem.setValorFinal(valorTotal);

            passagensCriadas.add(passagemRepository.save(passagem));
        }

        return passagensCriadas;
    }
}

