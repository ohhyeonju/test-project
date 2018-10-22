package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController {
    
    public Scanner keyScan;
    
    Member[] members = new Member[100];
    int memberIndex = 0;
    
    public void service(String menu, String option) {
        if (menu.equals("member/add")) {
            onMemberAdd();
        } else if (menu.equals("member/list")) {
            onMemberList();
        } else if (menu.equals("member/view")) {
            onMemberView(option);
        } else if (menu.equals("member/update")) {
            onMemberUpdate(option);
        } else if (menu.equals("member/delete")) {
            onMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    int getMemberIndex(String id) {
        for (int i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            if (id.equals(members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    void onMemberAdd() {
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        
        System.out.print("암호? ");
        member.password = keyScan.nextLine();
        
        members[memberIndex++] = member;
    }
    
    void onMemberList() {
        for (int i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            System.out.printf("%s, %s, %s\n",
                    members[i].id, members[i].email, members[i].password);
        }
    }
    void onMemberView(String id) {
        if (id == null) {
            System.out.println("팀명을 입력하세요");
            System.out.println();
            return;
        }
        int i = getMemberIndex(id);
        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }
    
    void onMemberUpdate(String id) {
        if (id == null) {
            System.out.println("팀명을 입력하세요");
            return;
        }
        int i = getMemberIndex(id);
        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            Member updateMember = new Member();
            System.out.printf("아이디(%s) ", member.id);
            updateMember.id = keyScan.nextLine();
            System.out.printf("이메일(%s)", member.email);
            updateMember.email = keyScan.nextLine();
            System.out.printf("암호(%s)", member.password);
            updateMember.password = keyScan.nextLine();
            members[i] = updateMember;
        }
    }
    
    void onMemberDelete(String id) {
        if (id == null) {
            System.out.println("팀명을 입력하세요");
            return;
        }
        int i = getMemberIndex(id);
        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                members[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}
