package com.pucminas.otre.otreprodutor.controller;

import com.pucminas.otre.otreprodutor.dto.ProdutorDto;
import com.pucminas.otre.otreprodutor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ProdutorController.BASE_PATH)
@RequiredArgsConstructor
public class ProdutorController {

    static final String BASE_PATH = "/produtores";

    private final ProdutorService produtorService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarProdutor(@RequestBody ProdutorDto produtor) {
        var produtorCriado = produtorService.criarProdutor(produtor);
        if(produtorCriado.isPresent()) {
            var retornoProdutor = produtorCriado.get();
            retornoProdutor.setSenha("");
            return ResponseEntity.ok(retornoProdutor);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody ProdutorDto produtor) {
        var produtorLogado = produtorService.login(produtor);
        if(produtorLogado.isPresent()) {
            var retornoProdutor = produtorLogado.get();
            retornoProdutor.setSenha("");
            return ResponseEntity.ok(retornoProdutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}