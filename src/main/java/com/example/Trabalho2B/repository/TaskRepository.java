package com.example.Trabalho2B.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Trabalho2B.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Você pode adicionar métodos customizados aqui, se necessário
}