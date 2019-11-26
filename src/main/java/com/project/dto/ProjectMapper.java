package com.project.dto;

import com.project.model.Project;

import static com.project.ProjyesApplication.modelMapper;

public class ProjectMapper {

    public static Project toProjectEntity(ProjectDto projectDto){
        return modelMapper().map(projectDto, Project.class);
    }

    public static ProjectDto toProjectDto(Project project){
        return modelMapper().map(project, ProjectDto.class);
    }
}
