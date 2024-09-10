package com.example.demo.service;

import com.example.demo.cadastroConfig.CadastroConfig;
import com.example.demo.cadastroConfig.CadastroConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cumbuco")
public class CadastroService {

    @Autowired
    private CadastroConfigRepository cadastroConfigRepository; // Injeção do repositório

    // Endpoint para salvar um novo usuário
    @PostMapping("/send-user")
    public String cadastrarNovoUser(@RequestBody CadastroConfig body) {
        // Salva o usuário no banco de dados
        cadastroConfigRepository.save(body);
        return "Usuário cadastrado: " + body.getNome() + ".";
    }

    // Endpoint para buscar um usuário pelo ID
    @GetMapping("/get-user/{id}")
    public CadastroConfig resgatarUser(@PathVariable Long id) {
        // Busca o usuário pelo ID e retorna os dados
        return cadastroConfigRepository.findById(id).orElse(null);
    }
}
