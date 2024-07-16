package com.ausiane.forumHub.forum_hub.domain.topico.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensagem) {
}
