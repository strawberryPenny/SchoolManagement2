package userinterface;

import controller.CourseController;
import database.*;
import entities.Course;

import java.util.List;

public class CourseConsoleUI {

    CourseController cc;
    MainConsoleUI mainUI;
    ConsoleInput input;

    public CourseConsoleUI(CourseController cc, MainConsoleUI mainUI, ConsoleInput input) {
        this.cc = cc;
        this.mainUI = mainUI;
        this.input = input;
    }

    public void printCourseMenu() {
        System.out.print("""
                                
                _______________________________________________
                                School Management
                                   Course Menu
                _______________________________________________
                1. Add Course
                2. Update Subject
                3. Update Course Points
                4. Add Course to Education
                5. Add Course to Teacher
                6. Remove Course From Education
                7. Remove Course From Teacher
                8. Remove Course
                9. Find Course by Subject
                10. Show All Courses
                11. Show All Courses Without an Education
                12. Show All Courses Without a Teacher
                0. Back to Main Menu

                Please choose: """);
    }

    public void readCourseUI() {
        System.out.print("\nPlease enter name of course subject: ");
        String subject = input.readString();

        System.out.print("Please enter course points: ");
        int points = input.readInt();

        cc.createCourse(subject, points);

        System.out.println("\nCourse has been added!");
    }

    public void updateCourseSubjectUI() {

        System.out.println("Please enter ID of course: ");

        int id = input.readInt();

        System.out.println("Please enter new subject: ");

        String subject = input.readString();

        cc.updateCourseSubjectController(id, subject);

        System.out.println("Course subject has been updated!");

    }

    public void updateCoursePointsUI() {
        System.out.println("Please enter ID of Course: ");

        int id = input.readInt();

        System.out.println("Please enter new course points: ");

        int coursePoints = input.readInt();

        cc.updateCoursePointsController(id, coursePoints);

        System.out.println("Course points have been updated!");

    }

    public void addEducationToCourseUI() {
        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        cc.addCourseToEducationController(cID, eID);

        System.out.println("\nEducation and Course has been joined! ");
    }

    public void addCourseToTeacherUI() {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        cc.addCourseToTeacherController(courseId, teacherId);

        System.out.println("\nCourse has been added to teacher!");
    }

    public void removeEducationFromCourseUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        cc.removeCourseFromEducationController(cID, eID);

        System.out.println("\nEducation has been removed from course!");
    }

    public void removeCourseFromTeacherUI() {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        cc.removeCourseFromTeacherController(courseId, teacherId);

        System.out.println("\nCourse has been removed from teacher!");
    }


    public void removeCourseByIdUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        cc.removeCourseById(courseId);

        System.out.println("\nThe course has been removed!");
    }

    public void findCourseBySubjectUI() {
        System.out.print("\nPlease enter subject of course: ");
        String subject = input.readString();

        List<Course> courses = cc.findCourseBySubjectController(subject);

        mainUI.printList(courses);
    }

    public void findCourseByIdUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        Course course = cc.findCourseController(courseId);

        mainUI.printCourse(course);
    }

    public void showAllCoursesUI() {
        List<Course> courses = cc.showAllCoursesController();

        mainUI.printList(courses);
    }

    public void showAllCoursesWithoutEducationUI() {
        List<Course> courses = cc.showAllCoursesWithoutEducationController();

        mainUI.printList(courses);
    }

    public void showAllCoursesWithoutTeacherUI() {
        List<Course> courses = cc.showAllCoursesWithoutTeacherController();

        mainUI.printList(courses);
    }
}