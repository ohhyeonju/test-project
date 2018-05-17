package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController {
    Scanner keyScan;
    MemberDao memberDao;
    public MemberController(Scanner keyScan, MemberDao memberDao) {
        this.keyScan = keyScan;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("member/add")) {
            memberAdd();
        } else if (menu.equals("member/list")) {
            memberList();
        } else if (menu.equals("member/view")) {
            memberView(option);
        } else if (menu.equals("member/update")) {
            onMemberUpdate(option);
        } else if (menu.equals("member/delete")) {
            onMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    
    void memberAdd() {
        Member member = new Member();
        System.out.print("아아디? ");
        member.setId(keyScan.nextLine());
        System.out.print("이메일? ");
        member.setEmail(keyScan.nextLine());
        System.out.print("암호? ");
        member.setPassword(keyScan.nextLine());
        memberDao.insert(member);
    }
    
    void memberList() {
        Member[] list = memberDao.list();
        for (Member member : list) {
            System.out.printf("%s, %s\n" , 
                    member.getId(), member.getEmail());
        }
    }
    
    void memberView(String id) {
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        
        if (member == null ) {
            System.out.println("해당 아이디의 회원이 없습니다");
        } else {
            System.out.printf("아이디: %s\n", member.getId());
            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("패스워드: %s\n", member.getPassword());
        }
    }
    
    void onMemberUpdate(String id) {
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다");
        } else {
            Member updateMember = new Member();
            System.out.printf("아이디: %s\n", member.getId());
            updateMember.setId(member.getId());
            System.out.printf("이메일(%s)? ", member.getEmail());
            updateMember.setEmail(keyScan.nextLine());
            System.out.printf("암호(%s)? ", member.getPassword());
            updateMember.setPassword(keyScan.nextLine());
            memberDao.update(updateMember);
            System.out.println("변경하였습니다.");
        }
    }
    
    void onMemberDelete(String id) {
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                memberDao.delete(id);
                System.out.println("삭제하였습니다.");
            }
        }
    }
}
