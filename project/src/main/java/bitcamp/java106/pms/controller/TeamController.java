package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamController {
    
    Scanner keyScan;
    
    Team[] teams = new Team[100];
    int teamIndex = 0;
    
    public TeamController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        if(menu.equals("team/add")) {
            onTeamAdd();
        } else if (menu.equals("team/list")) {
            onTeamList();
        } else if (menu.equals("team/view")) {
            onTeamView(option);
        } else if (menu.equals("team/update")) {
            onTeamUpdate(option);
        } else if (menu.equals("team/delete")) {
            onTeamDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    void onTeamAdd() {
        Team team = new Team();
        
        System.out.print("팀명? ");
        team.name = keyScan.nextLine();
        
        System.out.print("설명? ");
        team.description = keyScan.nextLine();

        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextInt();
        keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.startDate = Date.valueOf(keyScan.nextLine());

        System.out.print("종료일? ");
        team.endDate = Date.valueOf(keyScan.nextLine());
        
        teams[teamIndex++] = team;
    }
    
    void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n",
                    teams[i].name, teams[i].maxQty,
                    teams[i].startDate, teams[i].endDate);
        }
    }
    
    void onTeamView(String name) {
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return;
        }
        int i = getTeamIndex(name);
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            System.out.printf("팀명: %s\n", team.name);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n", 
                    team.startDate, team.endDate);
        }
    }
    
    void onTeamUpdate(String name) {
        System.out.println("팀 정보 변경");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        int i = getTeamIndex(name);
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            Team updateTeam = new Team();
            System.out.printf("팀명(%s)? ", team.name);
            updateTeam.name = keyScan.nextLine();
            System.out.printf("설명(%s)? ", team.description);
            updateTeam.description = keyScan.nextLine();
            System.out.printf("최대인원(%d)? ", team.maxQty);
            updateTeam.maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = Date.valueOf(keyScan.nextLine());
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = Date.valueOf(keyScan.nextLine());
            teams[i] = updateTeam;
        }
    }
    
    void onTeamDelete(String name) {
        System.out.println("팀 정보 삭제");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        int i = getTeamIndex(name);
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teams[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
}
