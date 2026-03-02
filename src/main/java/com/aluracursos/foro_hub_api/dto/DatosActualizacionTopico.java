package com.aluracursos.foro_hub_api.dto;

import jakarta.validation.constraints.NotNull; // <-- Esta línea es vital

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {}