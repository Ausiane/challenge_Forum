package com.ausiane.forumHub.forum_hub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosAtualizacaoTopico;
import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosCadastroTopico;
import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosDetalhamentoCadastroTopico;
import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosDetalhamentoTopico;
import com.ausiane.forumHub.forum_hub.domain.topico.dto.DadosListagemTopico;
import com.ausiane.forumHub.forum_hub.service.TopicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    /**
     * @param dados
     * @param uriBuilder
     * @return
     */
    @PostMapping
    public ResponseEntity<DadosDetalhamentoCadastroTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados,
                                                             UriComponentsBuilder uriBuilder) {
        var dadosDetalhamentoCadastroTopico = service.cadastrar(dados);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosDetalhamentoCadastroTopico.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoCadastroTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(sort = {"dataCriacao"},
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page<DadosListagemTopico> page = service.listar(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        DadosDetalhamentoTopico dadosDetalhamentoTopico = service.detalhar(id);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        DadosDetalhamentoTopico dadosDetalhamentoTopico = service.atualizar(id, dados);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
