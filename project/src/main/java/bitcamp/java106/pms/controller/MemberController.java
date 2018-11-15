package bitcamp.java106.pms.controller;

import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController implements Controller {
    
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
        member.setId(keyScan.nextLine());
        
        System.out.print("이메일? ");
        member.setEmail(keyScan.nextLine());
        
        System.out.print("암호? ");
        member.setPassword(keyScan.nextLine());
        
        memberDao.insert(member);
    }
    
    void onMemberList() {
        Iterator<Member> iterator = memberDao.list();
        while (iterator.hasNext()) {
            Member memeber = iterator.next();
            System.out.printf("%s, %s, %s\n",
                    memeber.getId(), memeber.getEmail(), 
                    memeber.getPassword());
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
            System.out.printf("아이디: %s\n", member.getId());
            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("암호: %s\n", member.getPassword());
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
            System.out.printf("아이디: %s\n", member.getId());
            updateMember.setId(member.getId());
            System.out.printf("이메일(%s)? ", member.getEmail());
            updateMember.setEmail(keyScan.nextLine());
            System.out.printf("암호? ");
            updateMember.setPassword(keyScan.nextLine());
            
            int index = memberDao.indexOf(member.getId());
            memberDao.update(index, updateMember);
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
