package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int count = 1;
    
    private int no;
    private String title;
    private String content;
    private Date createdDate;
    
    public Board() {
        this.no= count++;
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        if (no >= count) {
            count = no + 1;
        }
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
