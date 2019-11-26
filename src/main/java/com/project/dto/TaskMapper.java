package com.project.dto;

import com.project.model.Task;
import org.modelmapper.ModelMapper;

import static com.project.ProjyesApplication.modelMapper;

public class TaskMapper {

    public static Task toTaskEntity(TaskDto taskDto){
        return modelMapper().map(taskDto, Task.class);
    }

    public static TaskDto toTaskDto(Task task){
        return modelMapper().map(task, TaskDto.class);
    }
}
