package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class ProgramMedia implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
}