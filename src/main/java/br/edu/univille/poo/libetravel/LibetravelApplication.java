package br.edu.univille.poo.libetravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class LibetravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibetravelApplication.class, args);

		try {
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/libretravel",
					"postgres", "mandy1234");
			if (conexao != null) {
				System.out.println("Conectado com sucesso!");
			} else {
				System.out.println("Erro ao conectar ao Banco de Dados!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
