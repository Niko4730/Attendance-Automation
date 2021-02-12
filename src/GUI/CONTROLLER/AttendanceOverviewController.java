package GUI.CONTROLLER;

import BE.Student;
import BE.GUIHelper;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class AttendanceOverviewController {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 250;
    public static final Font FONT = new Font("System Bold", 24);
    @FXML
    private FlowPane flowPane;
    private List<Student> studentList;

    public void createStudents() {
        var studentList = new ArrayList<Student>();
        int amount = 3;
        for (int i = 0; i < amount; i++) {
            var firstName = String.format("%s %d", "Test First Name", i);
            var lastName = String.format("%s %d", "Test Last Name", i);
            var student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setPicture("Data/Pictures/shawn mendes.png");
            var studentPane = GUIHelper.createStudentBorderPane(student, FONT, WIDTH, HEIGHT);
            studentListFlowPane.getChildren().add(studentPane);
        }
    }
}
