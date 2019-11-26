package com.project.model;

import com.project.dto.BudgetItemDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BudgetItem extends BudgetItemDto {
}
