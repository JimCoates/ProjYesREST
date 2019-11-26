package com.project.service;

import com.project.dto.BudgetItemDto;
import com.project.repository.BudgetItemRepo;
import org.springframework.stereotype.Service;
import static com.project.dto.BudgetItemMapper.toBudgetItem;

@Service
public class BudgetItemService {

    private BudgetItemRepo budgetItemRepo;

    public BudgetItemService(BudgetItemRepo budgetItemRepo) {
        this.budgetItemRepo = budgetItemRepo;
    }

    public BudgetItemDto createBudgetItem(BudgetItemDto budgetItemDto) {
        return budgetItemRepo.save(toBudgetItem(budgetItemDto));
    }
}
