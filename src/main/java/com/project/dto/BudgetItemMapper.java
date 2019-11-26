package com.project.dto;

import com.project.model.BudgetItem;

import static com.project.ProjyesApplication.modelMapper;

public class BudgetItemMapper {

    public static BudgetItem toBudgetItem(BudgetItemDto budgetItemDto){
        return modelMapper().map(budgetItemDto, BudgetItem.class);
    }

    public static BudgetItemDto toBudgetItemDto(BudgetItem budgetItem){
        return modelMapper().map(budgetItem, BudgetItemDto.class);
    }

}
