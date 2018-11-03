package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.util.ArrayList;

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
        return cnt++;
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
    
    private int getTaskIndex(int taskNo) {
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task) collection.get(i);
            if (task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }
    
    public Task get(int taskNo) {
        int index = this.getTaskIndex(taskNo);
        if (index < 0) return null;
        return (Task) collection.get(index);
    }
    
    public void update(Task task) {
        int index = this.getTaskIndex(task.getNo());
        if (index < 0) return;
        collection.set(index, task);
    }
    
    public void delete(int taskNo) {
        int index = this.getTaskIndex(taskNo);
        if (index < 0) return;
        collection.remove(index);
    }
}
