package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao extends AbstractDao<Member> {
    
    public MemberDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        try (
                ObjectInputStream in = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("data/member.data")));
            ) {
            while (true) {
                try {
                    this.insert((Member) in.readObject());
                } catch (Exception e) {
                    //e.printStackTrace();
                    break;
                }
            }
        }
    }
    
    public void save() throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("data/member.data")));
            ) {
            Iterator<Member> members = this.list();
            
            while (members.hasNext()) {
                out.writeObject(members.next());
            }
        }
    }
    
    public int indexOf(Object key) {
        String id = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            Member originMember = collection.get(i);
            if (originMember.getId().toLowerCase().equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
