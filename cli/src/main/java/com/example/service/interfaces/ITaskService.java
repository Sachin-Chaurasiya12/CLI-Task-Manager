package com.example.service.interfaces;

import java.util.List;

import com.example.model.tasks;

public interface ITaskService{
    public void addService(String task) throws Exception;
    public List<tasks> getTaskService() throws Exception;
    public void markService(int id) throws Exception;
    public void deleteService(int id) throws Exception;
}
