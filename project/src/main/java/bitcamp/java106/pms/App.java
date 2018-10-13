package bitcamp.java106.pms;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public class App {

    static Scanner keyScan = new Scanner(System.in);
    
    static Team[] teams = new Team[100];
    static int teamIndex = 0;
    static String option = null;
    
    static Member[] members = new Member[100];
    static int memberIndex = 0;
    static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }
    
    static void onHelp() {
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
    
    static void onTeamAdd() {
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
    
    static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            System.out.printf("%s, %d, %s ~ %s\n",
                    teams[i].name, teams[i].maxQty,
                    teams[i].startDate, teams[i].endDate);
        }
    }
    
    static void onTeamView() {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return;
        }
        Team team = null;
        for (int i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].name.toLowerCase())) {
                team = teams[i];
                break;
            }
        }
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s\n", team.name);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n", 
                    team.startDate, team.endDate);
        }
    }
    static void onMemberAdd() {
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        
        System.out.print("암호? ");
        member.password = keyScan.nextLine();
        
        members[memberIndex++] = member;
    }
    
    static void onMemberList() {
        for (int i = 0; i < memberIndex; i++) {
            System.out.printf("%s, %s, %s\n",
                    members[i].id, members[i].email, members[i].password);
        }
    }
    static void onMemberView() {
        if (option == null) {
            System.out.println("팀명을 입력하세요");
            System.out.println();
            return;
        }
        Member member = null;
        for (int i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                break;
            }
        }
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }
    public static void main(String[] args) {
        
        while (true) {
            String[] input = prompt();
            
            String menu = input[0];
            
            if (input.length == 2) {
                option = input[1];
            } else {
                option = null;
            }
            
            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if(menu.equals("team/add")) {
                onTeamAdd();
            } else if (menu.equals("team/list")) {
                onTeamList();
            } else if (menu.equals("team/view")) {
                onTeamView();
            } else if (menu.equals("member/add")) {
                onMemberAdd();
            } else if (menu.equals("member/list")) {
                onMemberList();
            } else if (menu.equals("member/view")) {
                onMemberView();
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            } 
            System.out.println();
        }
        
    }
}
