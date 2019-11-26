package com.project.controller;

import com.project.dto.BudgetItemDto;
import com.project.dto.ProjectDto;
import com.project.dto.TaskDto;
import com.project.service.BudgetItemService;
import com.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.project.dto.ProjectMapper.toProjectEntity;

@CrossOrigin(origins = "https://localhost:8000")
@RestController
public class ProjectController {

    private ProjectService projectService;
    private BudgetItemService budgetItemService;


    public ProjectController(ProjectService projectService, BudgetItemService budgetItemService) {
        this.projectService = projectService;
        this.budgetItemService = budgetItemService;
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){

        ProjectDto project =  projectService.create(projectDto);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){

        List<ProjectDto> projects = projectService.getAll();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects/tasks/{projectId}")
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable Long projectId){

        List<TaskDto> tasks = projectService.getAllTasks(projectId);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("projects/{projectId}/budgetItem")
    public ResponseEntity<BudgetItemDto> createBudgetItem(@RequestBody BudgetItemDto budgetItemDto, @PathVariable Long projectId){

        budgetItemDto.setProject(toProjectEntity(projectService.findById(projectId)));

        BudgetItemDto newBudgetItem = budgetItemService.createBudgetItem(budgetItemDto);

        return new ResponseEntity<>(newBudgetItem, HttpStatus.CREATED);
    }

    @GetMapping("projects/{projectId}/budgetItems")
    public ResponseEntity<List<BudgetItemDto>> getAllBudgetItems(@PathVariable Long projectId){

        List<BudgetItemDto> budgetItemDtos = projectService.getAllBudgetItems(projectId);

        return new ResponseEntity<>(budgetItemDtos, HttpStatus.OK);
    }

    @PostMapping("projects/{projectId}/budget")
    public ResponseEntity<ProjectDto> setBudget(@PathVariable Long projectId, @RequestBody ProjectDto projectDto){

        ProjectDto project = projectService.setBudget(projectId, projectDto);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("projects/{projectId}/budget")
    public ResponseEntity<BigDecimal> setBudget(@PathVariable Long projectId){

        BigDecimal budget = projectService.getBudget(projectId);

        return new ResponseEntity<>(budget, HttpStatus.OK);
    }

    @PostMapping("projects/projectId/board")
    public ResponseEntity<ProjectDto> setBoardId(@PathVariable Long projectId, @RequestBody ProjectDto project) {

        ProjectDto projectDto = projectService.setBoard(project, projectId);

        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }


}
