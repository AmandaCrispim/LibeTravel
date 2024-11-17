package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.DadosPassageiros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosPassageirosRepository extends JpaRepository<DadosPassageiros, Long> {
}
