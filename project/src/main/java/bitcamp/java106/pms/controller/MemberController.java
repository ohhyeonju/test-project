package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController {
    
    Scanner keyScan;
    MemberDao memberDao;
    
    public MemberController(Scanner scanner, MemberDao memberDao) {
        this.keyScan = scanner;
        this.memberDao = memberDao;
    }
    
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
    
    void onMemberAdd() {
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        
        System.out.print("암호? ");
        member.password = keyScan.nextLine();
        
        memberDao.insert(member);
    }
    
    void onMemberList() {
        Member[] list = memberDao.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%s, %s, %s\n",
                    list[i].id, list[i].email, list[i].password);
        }
    }
    void onMemberView(String id) {
        if (id == null) {
            System.out.println("아이디을 입력하세요");
            return;
        }
        Member member = memberDao.get(id);
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
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
        Member member = memberDao.get(id);
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member updateMember = new Member();
            System.out.printf("아이디: %s\n", member.id);
            updateMember.id = member.id;
            System.out.printf("이메일(%s)? ", member.email);
            updateMember.email = keyScan.nextLine();
            System.out.printf("암호? ");
            updateMember.password = keyScan.nextLine();
            memberDao.update(updateMember);
            System.out.println("변경하였습니다.");
        }
    }
    
    void onMemberDelete(String id) {
        if (id == null) {
            System.out.println("팀명을 입력하세요");
            return;
        }
        Member member = memberDao.get(id);
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                memberDao.delete(id);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}
