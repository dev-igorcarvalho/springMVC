package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.ProdutoModel;
import br.com.casadocodigo.loja.models.enums.TipoPrecoEnum;
import java.util.logging.Logger;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutosController {

    private static final Logger LOG = Logger.getLogger(ProdutosController.class.getName());

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produtos/cadastro")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/cadastroForm");
        modelAndView.addObject("tipos", TipoPrecoEnum.values());
        return modelAndView;
    }

    @RequestMapping("/produtos")
    public String gravar(ProdutoModel produto) {
        System.out.println(produto);
        produtoDAO.save(produto);
        return "/produtos/cadastroSucesso";
    }

    @RequestMapping("/produtos/listar")
    public void listar() {
        System.out.println(produtoDAO.findAll());
    }
}
