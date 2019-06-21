package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.dao.abstracts.AbstractDAO;
import br.com.casadocodigo.loja.models.ProdutoModel;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProdutoDAO extends AbstractDAO<ProdutoModel> {

    private static final Logger LOG = Logger.getLogger(ProdutoDAO.class.getName());

    @Override
    public void save(ProdutoModel produto) {
        LOG.info("Save ProdutoDao");
        super.save(produto);
    }

    @Override
    public List<ProdutoModel> findAll() {
        LOG.info("FindAll ProdutoDao");
        return super.findAll();
    }
}
