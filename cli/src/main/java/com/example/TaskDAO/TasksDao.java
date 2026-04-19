package com.example.TaskDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import  org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import com.example.config.Database;
import com.example.model.tasks;

public class TasksDao {

    private static final Logger logger = LoggerFactory.getLogger(TasksDao.class);

    public void addTask(String name) throws Exception{
        String sql = "insert into tasks (title) values (?)";
         logger.debug("Inserting task: {}", name);
        try (Connection conn = Database.getdatasource().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, sql);
            stmt.executeUpdate();
        }

        logger.info("Task Created Successfully");
    }

    public List<tasks> getTask() throws Exception{
        String sql = "Select * from tasks";

        List<tasks> list = new ArrayList<>();

        try (Connection conn = Database.getdatasource().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)
            ){
                while (rs.next()) {
                    list.add(new tasks(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getBoolean("isDone")));
                }
            }
        return list;
    }
    
    public void markDone(int id) throws Exception{
        logger.debug("Mark the task {}", id);
        String sql = "Update into tasks set isDone = true where id = ?";
        try (Connection conn = Database.getdatasource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
    }

    public void deletetask(int id) throws Exception{
        logger.debug("delete the task {}", id);
        String sql = "delete from tasks where id = ? ";
        try (Connection conn = Database.getdatasource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        
    }
}
