package com.aluracursos.foro_hub_api.controller;

import com.aluracursos.foro_hub_api.domain.topico.Topico;
import com.aluracursos.foro_hub_api.dto.*;
import com.aluracursos.foro_hub_api.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(datos);
        repository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> retornarUnTopico(@PathVariable Long id) {
        var topico = repository.findById(id);
        return topico.map(value -> ResponseEntity.ok(new DatosDetalleTopico(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            var topicoActualizado = topico.get();
            topicoActualizado.actualizarDatos(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topicoActualizado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}