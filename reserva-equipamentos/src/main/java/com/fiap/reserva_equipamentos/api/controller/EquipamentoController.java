package com.fiap.reserva_equipamentos.api.controller;

import com.fiap.reserva_equipamentos.api.domain.Equipamento;
import com.fiap.reserva_equipamentos.api.service.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {
    private final EquipamentoService service;
    public EquipamentoController(EquipamentoService service) { this.service = service; }

    @GetMapping("/ativos")
    public List<Equipamento> ativos() { return service.listarAtivos(); }

    @GetMapping
    public List<Equipamento> buscar(@RequestParam(required = false, defaultValue = "") String q) {
        if (q.isBlank()) return service.listarAtivos();
        return service.buscar(q);
    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionarEquipamento(@RequestBody Equipamento equipamento) {
        try {
            service.salvar(equipamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipamento);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable Long id){
        try{
            service.deletar(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarEquipamento(@PathVariable Long id, @RequestBody Equipamento equipamento){
        try {
            service.editar(id, equipamento);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}