package com.project.service;

import com.project.dto.BudgetItemDto;
import com.project.dto.ProjectDto;
import com.project.dto.TaskDto;
import com.project.model.Project;
import com.project.model.Task;
import com.project.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.project.dto.ProjectMapper.toProjectDto;
import static com.project.dto.ProjectMapper.toProjectEntity;
import static com.project.dto.TaskMapper.toTaskDto;

@Service
public class ProjectService {

    private ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public ProjectDto create(ProjectDto projectDto) {

        projectDto.setBudget(BigDecimal.ZERO);

       Project project = projectRepo.save(toProjectEntity(projectDto));

       return toProjectDto(project);
    }

    public List<ProjectDto> getAll() {
        List<ProjectDto> projectDtos = new ArrayList<>();

        projectRepo.findAll().forEach(project -> projectDtos.add(toProjectDto(project)));

        return projectDtos;
    }

    public ProjectDto findById(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(NoSuchElementException::new);
        return toProjectDto(project);
    }

    private Project findProjectById(Long projectId) {
        return projectRepo.findById(projectId).orElseThrow((NoSuchElementException::new));
    }

    public List<TaskDto> getAllTasks(Long projectId) {
        ProjectDto project = findById(projectId);
        List<TaskDto> tasks = new ArrayList<>();
        for (Task task:project.getTasks()) {
            tasks.add(toTaskDto(task));
        }
        return tasks;
    }

    public List<BudgetItemDto> getAllBudgetItems(Long projectId) {
        ProjectDto project = findById(projectId);
        return new ArrayList<>(project.getBudgetItems());
    }

    public ProjectDto setBudget(Long projectId, ProjectDto projectDto) {
        Project project = findProjectById(projectId);
        project.setBudget(projectDto.getBudget());
        return toProjectDto(projectRepo.save(project));
    }

    public BigDecimal getBudget(Long projectId) {
        return findProjectById(projectId).getBudget();
    }

    public ProjectDto setBoard(ProjectDto project, Long projectId) {
        ProjectDto projectDto = findById(projectId);

        projectDto.setBoardId(project.getBoardId());
        projectDto.setImageUrl(project.getImageUrl());
        return projectRepo.save(toProjectEntity(projectDto));
    }
}
