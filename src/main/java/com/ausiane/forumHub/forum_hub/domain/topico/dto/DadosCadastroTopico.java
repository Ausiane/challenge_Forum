package com.ausiane.forumHub.forum_hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String curso,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor
) {
}
