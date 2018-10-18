package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamController {
    
    public static Scanner keyScan;
    
    static Team[] teams = new Team[100];
    static int teamIndex = 0;
    
    static int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public static void onTeamAdd() {
        Team team = new Team();
        
        System.out.print("팀명? ");
        team.name = keyScan.nextLine();
        
        System.out.print("설명? ");
        team.description = keyScan.nextLine();

        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextInt();
        keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        team.endDate = keyScan.nextLine();
        
        teams[teamIndex++] = team;
    }
    
    public static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n",
                    teams[i].name, teams[i].maxQty,
                    teams[i].startDate, teams[i].endDate);
        }
    }
    
    public static void onTeamView(String name) {
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
    
    public static void onTeamUpdate(String name) {
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
            updateTeam.startDate = keyScan.nextLine();
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = keyScan.nextLine();
            teams[i] = updateTeam;
        }
    }
    
    public static void onTeamDelete(String name) {
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
