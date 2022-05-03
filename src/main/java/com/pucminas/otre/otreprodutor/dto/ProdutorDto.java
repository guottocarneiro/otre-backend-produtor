package com.pucminas.otre.otreprodutor.dto;

import com.pucminas.otre.otreprodutor.model.Produtor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutorDto {
    private String email;
    private String senha;

    public Produtor converter() {
        return Produtor.builder().email(email).senha(senha).build();
    }
}
