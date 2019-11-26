package com.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.Project;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class TaskDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private String title;

    private String description;

    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
}
