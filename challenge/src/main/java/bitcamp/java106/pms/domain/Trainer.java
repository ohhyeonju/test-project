package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Trainer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String introduce; // 소개
    private String career; // 경력사항
    private Date time; // 상담시간
    private String account; // 계좌
    private String bank; // 은행명
    private int coin; // 수익금
    
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public int getCoin() {
        return coin;
    }
    public void setCoin(int coin) {
        this.coin = coin;
    }
}

//ver 31 - 생성자 제거.
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - 생성자 추가
//ver 17 - toString() 오버라이딩.
//         팀 멤버 관련 메서드를 TeamMemberDao 클래스로 옮긴다.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
//ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
//ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경