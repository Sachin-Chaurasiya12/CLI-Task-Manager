package com.example;

import com.example.TaskDAO.TasksDao;
import com.example.service.TaskService;
import com.example.service.interfaces.ITaskService;

public class Main {
    private static TasksDao dao = new TasksDao();
    public static ITaskService service = new TaskService(dao);
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            printHelp();
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                        System.out.println("Usage: add <task>");
                        return;
                    }
                service.addService(args[1]);
                System.out.println("Task added successfully");
                break;
            case "get" :
                service.getTaskService();
                break;
            case "mark":
                if (args.length < 2) {
                        System.out.println("Usage: done <id>");
                        return;
                    }
                    service.markService(Integer.parseInt(command));
                    System.out.println("Task marked done!");
                    break;
            case "delete":
                if(args.length < 2){
                    System.out.println("Usage: done <id>");
                    return;
                }
                service.deleteService(Integer.parseInt(command));
                System.out.println("Task deleted successfully");
                break;
            default:
                printHelp();
                break;
        }
    }
    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  add <task>");
        System.out.println("  list");
        System.out.println("  done <id>");
        System.out.println("  delete <id>");
    }
}