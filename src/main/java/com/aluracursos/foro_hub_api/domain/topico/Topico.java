package com.aluracursos.foro_hub_api.domain.topico;

import com.aluracursos.foro_hub_api.dto.DatosActualizacionTopico;
import com.aluracursos.foro_hub_api.dto.DatosRegistroTopico;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String autor;
    private String curso;

    // Constructor vacío requerido por JPA
    public Topico() {}

    // Constructor que recibe el DTO
    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public String getAutor() { return autor; }
    public String getCurso() { return curso; }



    public void actualizarDatos(DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.autor() != null) {
            this.autor = datos.autor();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}