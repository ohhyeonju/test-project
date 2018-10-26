package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[100];
    int teamIndex = 0;
    
    public void insert(Team team) {
        this.teams[this.teamIndex++] = team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[teamIndex];
        for (int i = 0; i < teamIndex; i++) {
            arr[i] = teams[i];
        }
        return arr;
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < this.teamIndex; i++) {
            if (this.teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public Team get(String name) {
        int i = getTeamIndex(name);
        if (i == -1) 
            return null;
        return teams[i];
    }
    
    public void update(Team team) {
        int i = getTeamIndex(team.name);
        if (i != -1)
            teams[i] = team;
    }
    
    public void delete(String name) {
        int i = getTeamIndex(name);
        if (i != -1)
            teams[i] = null;
    }
}