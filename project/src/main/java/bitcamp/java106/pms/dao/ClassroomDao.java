package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Classroom;

public class ClassroomDao {
    private LinkedList<Classroom> collection = new LinkedList<>();
    
    public void insert(Classroom classroom) {
        this.collection.add(classroom);
    }
    
    public Classroom[] list() {
        Classroom[] arr = new Classroom[collection.size()];
        return this.collection.toArray(arr);
    }
    

    private int getClassroomIndex(int classroomNo) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
    
    public Classroom get(int classroomNo) {
        int index = this.getClassroomIndex(classroomNo);
        if (index < 0) return null;
        return collection.get(index);
    }
    
    public void update(Classroom classroom) {
        int index = this.getClassroomIndex(classroom.getNo());
        if (index < 0) return;
        collection.set(index, classroom);
    }
    
    public void delete(int classroomNo) {
        int index = this.getClassroomIndex(classroomNo);
        if (index < 0) return;
        collection.remove(index);
    }
}
