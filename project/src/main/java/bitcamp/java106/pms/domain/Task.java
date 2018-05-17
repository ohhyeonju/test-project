package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    public static int count = 1;
    
    public int no;
    public String title;
    public Date startDate;
    public Date endDate;
    public int state;
    public Member worker;
    public Team team;
    
    public Task(Team team) {
        this.no = count++;
        this.team = team;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Member getWorker() {
        return worker;
    }

    public void setWorker(Member worker) {
        this.worker = worker;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Task [no=" + no + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state="
                + state + ", worker=" + worker + ", team=" + team + "]";
    }
    
}
