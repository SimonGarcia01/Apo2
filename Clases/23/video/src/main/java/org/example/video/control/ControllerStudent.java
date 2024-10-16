package org.example.video.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.video.model.Student;

import java.util.ArrayList;

public class ControllerStudent {

    private static ControllerStudent instance;

    public static ControllerStudent getInstance() {
        if(instance == null){
            instance = new ControllerStudent();
        }

        return instance;
    }

    private ObservableList<Student> students;

    private ControllerStudent() {
        students = FXCollections.observableArrayList();
    }

    public void addStudent(String name, String id, int age) {
        students.add(new Student(name, id, age));
    }

    public String printStudents(){
        String message = "";
        for(Student s : students){
            message += s.toString() + "\n";
        }
        return message;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }
}
