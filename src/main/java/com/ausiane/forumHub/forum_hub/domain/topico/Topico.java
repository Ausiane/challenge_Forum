package com.ausiane.forumHub.forum_hub.domain.topico;

import java.time.LocalDateTime;
import java.util.List;

import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosCadastroTopico;
import com.ausiane.forumHub.forum_hub.domain.topico.enums.Status;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;

    @ElementCollection
    private List<String> respostas;

    public Topico(DadosCadastroTopico dados) {
        titulo = dados.titulo();
        mensagem = dados.mensagem();
        dataCriacao = LocalDateTime.now();
        status = Status.NAO_RESPONDIDO;
        autor = dados.autor();
        curso = dados.curso();
    }
}
