package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
