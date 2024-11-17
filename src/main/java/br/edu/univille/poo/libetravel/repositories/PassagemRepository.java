package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
