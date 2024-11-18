package com.example.Trabalho2B.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trabalho2B.model.Task;
import com.example.Trabalho2B.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Método para buscar todas as tarefas
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Método para buscar tarefa por ID
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    // Método para salvar uma nova tarefa
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Método para atualizar uma tarefa existente
    public Task updateTask(Long id, Task taskDetails) {
        // Busca a tarefa pelo ID, caso não encontre, lança uma exceção
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        // Atualiza os campos da tarefa com os dados de taskDetails
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());  // Atualiza o status
        task.setPriority(taskDetails.getPriority());  // Atualiza a prioridade
        task.setDueDate(taskDetails.getDueDate());  // Atualiza a data de vencimento

        // Salva e retorna a tarefa atualizada
        return taskRepository.save(task);
    }

    // Método para deletar uma tarefa
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
