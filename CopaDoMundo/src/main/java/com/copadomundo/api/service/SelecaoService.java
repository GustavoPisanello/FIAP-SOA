
package com.copadomundo.api.service;

import com.copadomundo.api.model.Selecao;
import com.copadomundo.api.repository.SelecaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SelecaoService {
    private final SelecaoRepository repository;

    public SelecaoService(SelecaoRepository repository) {
        this.repository = repository;
    }

    public List<Selecao> listar() {
        return repository.findAll();
    }

    public Selecao salvar(Selecao time) {
        return repository.save(time);
    }

    public void GetRankingPosition(){
        String url = "https://inside.fifa.com/fifa-world-ranking/men";


    }
}
