package com.aluracursos.foro_hub_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso
) {}
