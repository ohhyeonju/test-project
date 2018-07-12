package bitcamp.java106.pms.dao;

import java.util.List;

import bitcamp.java106.pms.domain.Program;

public interface ProgramDao {

    public int delete(int no);
    public List<Program> selectList();
    public List<Program> selectListCard();
    public int insert(Program program);
    public int update(Program program);
    public Program selectOne(int no);
    //public Team selectOneWithMembers(String name);
}






