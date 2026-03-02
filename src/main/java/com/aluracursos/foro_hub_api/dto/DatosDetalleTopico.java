package com.aluracursos.foro_hub_api.dto;

import com.aluracursos.foro_hub_api.domain.topico.Topico;
import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
