package com.project.dto;

import com.project.model.BudgetItem;
import com.project.model.Task;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@MappedSuperclass
public class ProjectDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long projectId;

    String description;

    String name;

    @OneToMany(mappedBy = "project")
    List<Task> tasks;

    @OneToMany(mappedBy = "project")
    List<BudgetItem> budgetItems;

    BigDecimal budget;

    Long boardId;

    String imageUrl;
}

