package br.edu.univille.poo.libetravel.config;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import br.edu.univille.poo.libetravel.entities.Aeroporto;
import br.edu.univille.poo.libetravel.entities.Voo;
import br.edu.univille.poo.libetravel.repositories.AeronaveRepository;
import br.edu.univille.poo.libetravel.repositories.AeroportoRepository;
import br.edu.univille.poo.libetravel.repositories.VooRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadInitialData(
            VooRepository vooRepository,
            AeronaveRepository aeronaveRepository,
            AeroportoRepository aeroportoRepository) {
        return args -> {
            Aeroporto aeroporto1 = new Aeroporto(null, "Aeroporto de Brasília", "Brasília", "DF", "Brasil", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            Aeroporto aeroporto2 = new Aeroporto(null, "Aeroporto de São Paulo", "São Paulo", "SP", "Brasil", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            Aeroporto aeroporto3 = new Aeroporto(null, "Aeroporto do Rio de Janeiro", "Rio de Janeiro", "RJ", "Brasil", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            aeroportoRepository.save(aeroporto1);
            aeroportoRepository.save(aeroporto2);
            aeroportoRepository.save(aeroporto3);

            Aeronave aeronave1 = new Aeronave(null, "Aeronave Azul", null, null);
            Aeronave aeronave2 = new Aeronave(null, "Aeronave Gol", null, null);
            Aeronave aeronave3 = new Aeronave(null, "Aeronave LATAM", null, null);
            aeronaveRepository.save(aeronave1);
            aeronaveRepository.save(aeronave2);
            aeronaveRepository.save(aeronave3);

            Voo voo1 = new Voo(null, "Brasília", "São Paulo", LocalDateTime.of(2024, 12, 10, 10, 30), 300.00, "Azul", aeronave1, aeroporto1, aeroporto2);
            Voo voo2 = new Voo(null, "São Paulo", "Brasília", LocalDateTime.of(2024, 12, 11, 15, 0), 350.00, "Gol", aeronave2, aeroporto2, aeroporto1);
            Voo voo3 = new Voo(null, "Rio de Janeiro", "Porto Alegre", LocalDateTime.of(2024, 12, 12, 9, 45), 400.00, "LATAM", aeronave3, aeroporto3, aeroporto1);

            vooRepository.save(voo1);
            vooRepository.save(voo2);
            vooRepository.save(voo3);

            System.out.println("Dados iniciais de voos carregados no banco!");
        };
    }
}