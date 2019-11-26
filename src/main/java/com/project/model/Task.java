package com.project.model;

import com.project.dto.TaskDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Task extends TaskDto {

}
