package com.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.Project;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public class BudgetItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long budgetItemId;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
}
