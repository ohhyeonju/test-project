package bitcamp.java106.pms.dao;

import java.util.ArrayList;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    private ArrayList collection = new ArrayList(); 
    
    public void insert(Task task) {
        collection.add(task);
    }
    
    private int count(String teamName) {
        int cnt = 0;
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task) collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < collection.size(); i++) {
            Task task = (Task) collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                arr[x++] = task;
            }
        }
        return arr;
    }
    
    public Task get(String teamName, int taskNo) {
        for (int i = 0; i < collection.size(); i++) {
            Task task = collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(teamName) &&
                task.getNo() == taskNo) {
                return task;
            }
        }
        return null;
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int taskNo) {
        tasks[taskNo] = null;
    }
}
