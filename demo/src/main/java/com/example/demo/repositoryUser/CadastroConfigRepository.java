package com.example.demo.cadastroConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroConfigRepository extends JpaRepository<CadastroConfig, Long> {
}
