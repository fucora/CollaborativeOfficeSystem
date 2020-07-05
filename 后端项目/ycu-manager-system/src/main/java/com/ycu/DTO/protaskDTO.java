package com.ycu.DTO;

import com.ycu.pojo.project;
import com.ycu.pojo.task;
import lombok.Data;

import java.util.List;

@Data
public class protaskDTO {

private project project;
private List<task> tasks;

    public protaskDTO(com.ycu.pojo.project project, List<task> tasks) {
        this.project = project;
        this.tasks = tasks;
    }
}
