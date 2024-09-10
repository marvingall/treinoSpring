package com.example.demo.service;

import com.example.demo.cadastroConfig.CadastroConfig;
import com.example.demo.cadastroConfig.CadastroConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class importService {

    @Autowired
    private CadastroConfigRepository cadastroConfigRepository; // Injeção do repositório

    public void importarJson(String caminhoArquivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(caminhoArquivo);

        // Supondo que o JSON contém uma lista de objetos CadastroConfig
        CadastroConfig[] usuarios = objectMapper.readValue(file, CadastroConfig[].class);

        // Salva todos os usuários no banco de dados
        cadastroConfigRepository.saveAll(Arrays.asList(usuarios));
    }
}
