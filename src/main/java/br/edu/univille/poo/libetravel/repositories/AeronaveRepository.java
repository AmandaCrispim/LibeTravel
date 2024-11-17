package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {
}
