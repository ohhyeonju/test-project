package bitcamp.java106.pms.dao;

import java.util.ArrayList;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    private ArrayList collection = new ArrayList();
    
    public void insert(Member member) {
        collection.add(member);
    }
    
    public Member[] list() {
        Member[] arr = new Member[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            arr[i] = (Member) collection.get(i);
        }
        return arr;
    }
    
    private int getMemberIndex(String id) {
        for (int i = 0; i < collection.size(); i++) {
            Member originMember = (Member) collection.get(i);
            if (originMember.getId().toLowerCase().equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public Member get(String id) {
        int i = getMemberIndex(id);
        if (i == -1)
            return null;
        return (Member) collection.get(i);
    }
    
    public void update(Member member) {
        int i = getMemberIndex(member.getId());
        if (i != -1)
            collection.set(i, member);
    }
    
    public void delete(String id) {
        int i = getMemberIndex(id);
        if (i != -1)
            collection.remove(i);
    }
}
