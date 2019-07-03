package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.ProdutoModel;
import br.com.casadocodigo.loja.models.enums.TipoPrecoEnum;
import br.com.casadocodigo.loja.validators.ProdutoValidator;
import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    private static final Logger LOG = Logger.getLogger(ProdutosController.class.getName());

    @Autowired
    private ProdutoDAO produtoDAO;

    /*liga o controler ao validator escolhido*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidator());
    }

    @RequestMapping("/cadastroForm")
    public ModelAndView form() {
        //ModelAndView é a classe responsavel por disponibilizar o objeto para a View
        ModelAndView modelAndView = new ModelAndView("produtos/cadastroForm");
        modelAndView.addObject("tipos", TipoPrecoEnum.values());
        return modelAndView;
    }

    
    
    /*@Valid vem do beanValidataion do javax.validation, usando o implementação do hibernate.
    BindingResult carrega os possiveis erros de validação, e para funcionar ele deve ser passado como parametro logo após
    o model q recebeu o @valid, deve ser mantida a ordem dos parametros que é usada neste exemplo*/
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(@Valid ProdutoModel produto,  BindingResult result, RedirectAttributes redirectAttributes) {
        System.out.println(produto);
        
        //se tiver erros de validação devolve o usuario para o form
        if(result.hasErrors()){
            return this.form();
        }
        produtoDAO.save(produto);
        // pendura um objeto na requisição e passa ele para a proxima encadeada.
        //RedirectAttributes é um escopo onde os objetos adicionados duram apenas o tempo de um request para outro.
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastro com sucesso");
        // o redirect: faz a chamada do metodo mapeado na url do mesmo nome
        // também é boa pratica usar isso para evitar q o usuario repita o ultimo request post dando refresh no navegador
        return new ModelAndView("redirect:produtos/listar");
    }

    @RequestMapping("/listar")
    public ModelAndView listar() {
        List<ProdutoModel> produtos = produtoDAO.findAll();
        System.out.println(produtos + "\n");
        ModelAndView modelAndView = new ModelAndView("produtos/produtosLista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
}
