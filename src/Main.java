import Controller.StudentController;
import View.Student_view;

public class Main {
    public static void main(String[] args) {
            Student_view studentView = new Student_view();
            StudentController studentController = new StudentController(studentView);
            studentView.setVisible(true);

    }

}
