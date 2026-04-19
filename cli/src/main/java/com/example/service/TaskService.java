package com.example.service;

import java.util.List;

import com.example.TaskDAO.TasksDao;
import com.example.model.tasks;
import com.example.service.interfaces.ITaskService;

public class TaskService implements ITaskService{

    private TasksDao dao;
    public TaskService(TasksDao dao){
        this.dao = dao;
    }

    @Override
    public void addService(String task) throws Exception {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        dao.addTask(task);
    }

    @Override
    public List<tasks> getTaskService() throws Exception{
        return dao.getTask();
    }

    @Override
    public void markService(int id) throws Exception {
        dao.markDone(id);
    }

    @Override
    public void deleteService(int id) throws Exception {
       dao.deletetask(id);
    }
    
}
