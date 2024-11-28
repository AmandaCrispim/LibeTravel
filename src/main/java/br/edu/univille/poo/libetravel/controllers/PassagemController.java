package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Passagem;
import br.edu.univille.poo.libetravel.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagens")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @PostMapping("/lote")
    public ResponseEntity<String> criarPassagens(@RequestBody List<Passagem> passagens) {
        try {
            List<Passagem> passagensCriadas = passagemService.criarPassagens(passagens);
            return ResponseEntity.status(HttpStatus.CREATED).body("Passagens criadas com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



