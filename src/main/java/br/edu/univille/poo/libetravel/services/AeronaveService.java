import br.edu.univille.poo.libetravel.entities.Aeronave;
import br.edu.univille.poo.libetravel.entities.Assento;
import br.edu.univille.poo.libetravel.repositories.AeronaveRepository;
import br.edu.univille.poo.libetravel.repositories.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeronaveService {

    @Autowired
    private AeronaveRepository repository;

    @Autowired
    private AssentoRepository assentoRepository;

    public List<Aeronave> listarAeronaves() {
        return repository.findAll();
    }

    public Aeronave buscarAeronavePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aeronave não encontrada"));
    }

    public Aeronave criarAeronave(Aeronave aeronave) {
        Aeronave novaAeronave = repository.save(aeronave);


        double precoJanela = 300.00;
        double precoMeio = 150.00;
        double precoCorredor = 200.00;


        List<Assento> assentos = Assento.gerarAssentos(novaAeronave, precoJanela, precoMeio, precoCorredor);

        assentoRepository.saveAll(assentos);

        return novaAeronave;
    }

    public Aeronave atualizarAeronave(Long id, Aeronave aeronave) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeronave não encontrada");
        }
        aeronave.setId(id);
        return repository.save(aeronave);
    }

    public void deletarAeronave(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeronave não encontrada");
        }
        repository.deleteById(id);
    }
}
