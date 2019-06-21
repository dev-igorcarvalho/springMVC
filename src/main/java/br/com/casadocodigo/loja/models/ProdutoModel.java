package br.com.casadocodigo.loja.models;

import br.com.casadocodigo.loja.models.abstracts.AbstractModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class ProdutoModel extends AbstractModel {

    private static final long serialVersionUID = -7693345440587953319L;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "paginas")
    private int paginas;
    
    @ElementCollection
    private List<PrecoModel> precos;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public List<PrecoModel> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoModel> precos) {
        this.precos = precos;
    }


    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }

}
