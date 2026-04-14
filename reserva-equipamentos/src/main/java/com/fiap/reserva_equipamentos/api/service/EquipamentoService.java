package com.fiap.reserva_equipamentos.api.service;

import com.fiap.reserva_equipamentos.api.domain.Equipamento;
import com.fiap.reserva_equipamentos.api.repository.EquipamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {
    private final EquipamentoRepository repo;
    public EquipamentoService(EquipamentoRepository repo) { this.repo = repo; }

    public List<Equipamento> listarAtivos() { return repo.findByAtivoTrue(); }
    public List<Equipamento> buscar(String termo) { return repo.findByDescricaoContainingIgnoreCase(termo); }

    public Equipamento salvar(Equipamento equipamento) {
        return repo.save(equipamento);
    }

    public void deletar(Long id){
        repo.deleteById(id);
    }

    public void editar(Long id, Equipamento novoEquipamento){
        Equipamento equipamento = repo.findById(id).orElseThrow();
        equipamento.descricao = novoEquipamento.descricao;
        equipamento.ativo = novoEquipamento.ativo;

        repo.save(equipamento);
    }
}