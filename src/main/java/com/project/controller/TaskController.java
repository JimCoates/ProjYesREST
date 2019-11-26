package com.project.controller;

import com.project.dto.TaskDto;
import com.project.service.ProjectService;
import com.project.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.dto.ProjectMapper.toProjectEntity;

@RestController
public class TaskController {

    private TaskService taskService;
    private ProjectService projectService;

    public TaskController(TaskService taskService, ProjectService projectService){
        this.taskService = taskService;
        this.projectService = projectService;
    }
    @CrossOrigin(origins = "https://localhost:8000")
    @PostMapping("/tasks/{projectId}")
    public ResponseEntity<List<TaskDto>> createTask(@RequestBody TaskDto taskDto, @PathVariable Long projectId) {
        taskDto.setProject(toProjectEntity(projectService.findById(projectId)));

        TaskDto task = taskService.create(taskDto);

        List<TaskDto> tasks = projectService.getAllTasks(projectId);

        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://localhost:8000")
    @PostMapping("/tasks/{taskId}/complete")
    public ResponseEntity<TaskDto> markDone(@PathVariable Long taskId) {

        TaskDto task = taskService.markDone(taskId);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
