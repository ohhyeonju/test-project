package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    Scanner keyScan;
    BoardDao boardDao = new BoardDao();
            
    public BoardController(Scanner keyScan) {
        this.keyScan = keyScan;
    }
    
        
    public void service(String menu, String option) {
        if (menu.equals("board/add")) {
            boardAdd();
        } else if (menu.equals("board/list")) {
            boardList();
        } else if (menu.equals("board/view")) {
            boardView(option);
        } else if (menu.equals("board/update")) {
            onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            onBoardDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    void boardAdd() {
        System.out.println("[게시글 등록]");
        Board board = new Board();
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        System.out.print("등록일? ");
        board.setCreatedDate(Date.valueOf(keyScan.nextLine()));
        boardDao.insert(board);
    }
    
    void boardList() {
        System.out.println("[게시글 목록]");
        Board[] list = boardDao.list();
        for (Board board : list) {
            System.out.printf("%d, %s, %s\n" , 
                    board.getNo(), board.getTitle(), board.getCreatedDate());
        }
    }
    
    void boardView(String option) {
        System.out.println("[게시글 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(option));
        if (board == null) {
            System.out.println("해당 번호의 게시글이 없습니다.");
            
        } else {
            System.out.printf("제목: %s\n", board.getTitle());
            System.out.printf("내용: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
        }
    }
    
    void onBoardUpdate(String option) {
        System.out.println("[게시글 변경]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(option));
        if (board == null) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        
        } else {
            Board updateBoard = new Board();
            System.out.printf("제목(%s)? ", board.getTitle());
            updateBoard.setTitle(keyScan.nextLine());
            System.out.printf("내용(%s) ", board.getContent());
            updateBoard.setContent(keyScan.nextLine());
            updateBoard.setCreatedDate(board.getCreatedDate());
            updateBoard.setNo(board.getNo());
            boardDao.update(updateBoard);
            System.out.println("변경하였습니다.");
        }
    }
    
    void onBoardDelete(String option) {
        System.out.println("[게시글 삭제]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = Integer.parseInt(option);
        Board board = boardDao.get(i);
        if (board == null) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                boardDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}
