package com.ausiane.forumHub.forum_hub.domain.topico.dto;

import java.util.List;

import com.ausiane.forumHub.forum_hub.domain.topico.Topico;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String curso,
        String mensagem,
        String autor,
        List<String> respostas) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getCurso(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getRespostas());
    }
}
