/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models;

import br.com.casadocodigo.loja.models.enums.TipoPrecoEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author dg
 */
@Embeddable
public class PrecoModel implements Serializable {

    private static final long serialVersionUID = -2289006015518683841L;

    private BigDecimal preco;

//    @Enumerated(EnumType.STRING)
    private TipoPrecoEnum tipoPrecoEnum;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public TipoPrecoEnum getTipoPrecoEnum() {
        return tipoPrecoEnum;
    }

    public void setTipoPrecoEnum(TipoPrecoEnum tipoPrecoEnum) {
        this.tipoPrecoEnum = tipoPrecoEnum;
    }

}
