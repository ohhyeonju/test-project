package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    
    private HashMap<String, ArrayList<String>> collection = new HashMap<>();
    
    public TeamMemberDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/teammember.csv"));
        while (true) {
            try {
                String[] arr = in.nextLine().split(":");
                String[] idList = arr[1].split(",");
                ArrayList<String> list = new ArrayList<>();
                for (String id : idList) {
                    list.add(id);
                }
                collection.put(arr[0], list);
            } catch (Exception e) {
                //e.printStackTrace();
                break;
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/teammember.csv"));
        Set<String> keyList = collection.keySet();
        for (String key : keyList) {
            List<String> idList = collection.get(key);
            out.printf("%s:", key);
            for (String id : idList) {
                out.printf("%s,", id);
            }
            out.println();
        }
        out.close();
    }
    
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
