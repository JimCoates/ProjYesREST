package com.project.model;

import com.project.dto.ProjectDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Project extends ProjectDto{
}
