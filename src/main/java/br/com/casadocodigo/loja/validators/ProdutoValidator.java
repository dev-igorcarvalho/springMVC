/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.validators;

import br.com.casadocodigo.loja.models.ProdutoModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author dg
 */
public class ProdutoValidator implements Validator {

    // Configuração necessária para o funcionamento do validator no spring
    //Diz para o spring qual o model que é ligado a esse validator
    @Override
    public boolean supports(Class<?> type) {
        return ProdutoModel.class.isAssignableFrom(type); 
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required"); // Ler a documentação do ValidationUtils - LEMBRETE

        ProdutoModel produto = (ProdutoModel) target;

        if (produto.getPaginas() <= 0) {
            // ler a documentação dos erros e suas opçoes - LEMBRETE
            errors.rejectValue("paginas", "field.required");
        }
    }
}
