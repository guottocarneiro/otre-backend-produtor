package com.pucminas.otre.otreprodutor.service;

import com.pucminas.otre.otreprodutor.dto.ProdutorDto;
import com.pucminas.otre.otreprodutor.model.Produtor;
import com.pucminas.otre.otreprodutor.repositories.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public Optional<Produtor> criarProdutor(ProdutorDto produtorDto) {
        var produtorToBeCreated = produtorDto.converter();
        var produtor = produtorRepository.save(produtorToBeCreated);
        return Optional.of(produtor);
    }

    public Optional<Produtor> login(ProdutorDto produtorDto) {
        var produtor = produtorRepository.findByEmailAndSenha(produtorDto.getEmail(), produtorDto.getSenha());
        if(produtor != null) {
            return Optional.of(produtor);
        } else {
            return Optional.empty();
        }
    }
}

