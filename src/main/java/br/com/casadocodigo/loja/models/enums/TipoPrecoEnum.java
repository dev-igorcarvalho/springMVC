/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models.enums;

/**
 *
 * @author dg
 */
public enum TipoPrecoEnum {

    EBOOK("E-book"),
    IMPRESSO("Impresso"),
    COMBO("Combo");

    private TipoPrecoEnum(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }

}
