package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Board {
    private static int count = 1;
    
    private int no;
    private String title;
    private String content;
    private Date createdDate;
    
    public int getNo() {
        return no = count++;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
