package bitcamp.java106.pms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    
    private HashMap<String, ArrayList<String>> collection = new HashMap<>();
    
    public int addMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null) {
            members = new ArrayList<>();
            members.add(memberIdLC);
            collection.put(teamNameLC, members);
            return 1;
        }
        
        if (members.contains(memberIdLC))
            return 0;
        
        members.add(memberIdLC);
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC))
            return 0;
        
        members.remove(memberIdLC);
        return 1;
    }
    
    public Iterator<String> getMembers(String teamName) {
        ArrayList<String> members = collection.get(teamName.toLowerCase());
        if (members == null)
            return null;
        return members.iterator();
    }
    
    public boolean isExist(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC))
                return false;
        return true;
    }
}
