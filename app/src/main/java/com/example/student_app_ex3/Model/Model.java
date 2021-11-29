package com.example.student_app_ex3.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model() {
        for (int i = 0; i < 20; i++) {
            Student s = new Student("name", "" + i, "", "", false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public void removeStudent(Student student){
        for(Student s:data)
        {
            if(s.id.equals(student.getId()))
            {
                data.remove(s);
                break;
            }
        }
    }

    public Student getStudent(String string) {


        for (int i = 0; i < data.size(); i++) {
            String temp = data.get(i).getId();
            if (temp.compareTo(string) == 0) {
                Student student = data.get(i);
                return student;
            }
        }
        return null;
    }

    public void updateList(Student oldStudent, Student newStudent) {
        boolean check = false;
            for (Student s : data) {
                if (s.id.equals(oldStudent.getId())) {
                    s.setName(newStudent.name);
                    s.setId(newStudent.id);
                    s.setPhone(newStudent.phone);
                    s.setAddress(newStudent.address);
                    s.setFlag(newStudent.flag);
                }
            }



    }
}
