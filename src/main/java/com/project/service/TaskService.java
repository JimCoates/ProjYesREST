package com.project.service;

import com.project.dto.TaskDto;
import com.project.model.Task;
import com.project.repository.TaskRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.project.dto.TaskMapper.toTaskDto;
import static com.project.dto.TaskMapper.toTaskEntity;

@Service
public class TaskService {

    TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public TaskDto create(TaskDto taskDto) {
        taskDto.setIsCompleted(false);
        Task task = taskRepo.save(toTaskEntity(taskDto));
        return toTaskDto(task);
    }

    public Task findById(Long taskId) {
        return taskRepo.findById(taskId).orElseThrow(EntityNotFoundException::new);
    }

    public TaskDto markDone(Long taskId) {
        Task task = findById(taskId);

        task.setIsCompleted(true);

        return toTaskDto(taskRepo.save(task));
    }
}
