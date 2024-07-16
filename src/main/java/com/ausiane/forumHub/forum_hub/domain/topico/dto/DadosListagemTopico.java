package com.ausiane.forumHub.forum_hub.domain.topico.dto;

import java.time.LocalDateTime;

import com.ausiane.forumHub.forum_hub.domain.topico.Topico;
import com.ausiane.forumHub.forum_hub.domain.topico.enums.Status;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Status status,
        String autor,
        String curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
