
package com.exemplo.springcrud.controller;

import com.exemplo.springcrud.model.Produto;
import com.exemplo.springcrud.repository.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repo;

    public ProdutoController(ProdutoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", repo.findAll());
        return "lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "formulario";
    }

    @PostMapping
    public String salvar(Produto produto) {
        repo.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Produto produto = repo.findById(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "formulario";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable Long id, Model model) {
        Produto produto = repo.findById(id).orElseThrow();
        model.addAttribute("produto", produto);
        return "visualizar";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/produtos";
    }
}
