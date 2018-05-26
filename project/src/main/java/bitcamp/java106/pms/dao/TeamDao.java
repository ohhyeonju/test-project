package bitcamp.java106.pms.dao;

import java.util.ArrayList;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    
    private ArrayList collection = new ArrayList();
    
    public void insert(Team team) {
        collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[collection.size()];
        for (int i = 0; i < this.collection.size(); i++) {
            arr[i] = (Team) this.collection.get(i);
        }
        return arr;
    }

    public Team get(String name) {
        int i;
        if ((i = getTeamIndex(name)) != -1)
            return (Team) collection.get(i);
        return null;
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < collection.size(); i++) {
            if (name.toLowerCase().equals(
                    ((Team) collection.get(i)).getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    
    public void update(Team team) {
        int i;
        if ((i = getTeamIndex(team.getName())) != -1)
            collection.set(i, team);
    }
    
    public void delte(String name) {
        int i;
        if ((i = getTeamIndex(name)) != -1)
            collection.remove(i);
    }
}
