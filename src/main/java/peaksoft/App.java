package peaksoft;

import peaksoft.configuration.DatabaseConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DatabaseConfig.getEntityManager();
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();

        while (true) {
            System.out.println("""
                    ~~~~~~Task~~~~~~~~
                    1.SAVE TASK
                    2.UPDATE TASK
                    3.GET ALL TASKS BY LESSON ID
                    4.DELETE TASK BY ID
                    
                    ~~~~~~Course~~~~~~
                    5.SAVE COURSE
                    6.GET COURSE BY ID
                    7.GET ALL COURSES SORT BY CREATE AT
                    8.UPDATE COURSE
                    9.DELETE COURSE BY ID
                    10.GET COURSE BY NAME
                    
                    ~~~~~~Lesson~~~~~~
                    11.SAVE LESSON
                    12.UPDATE LESSON
                    13.GET LESSON BY ID
                    14.GET LESSONS BY COURSE ID
                    
                    ~~~~~Instructor~~~~~~~
                    15.SAVE INSTRUCTOR
                    16.UPDATE INSTRUCTOR
                    17.GET INSTRUCTOR BY ID
                    18.GET INSTRUCTORS BY COURSE ID
                    19.DELETE INSTRUCTOR BY ID
                    20.ASSIGN INSTRUCTOR TO COURSE
                    
                    write command:
                    """);
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    Task task1 = new Task("12:00", "task-jdbs");
                    Task task2 = new Task("22:45", "task-hibernate");
                    Task task3 = new Task("11:00", "task-join");
                    Task task4 = new Task("18:30", "task-relationship");
                    Task task5 = new Task("14:20", "task-sql");
                    System.out.println(taskService.saveTask(1L,task5));
                    break;
                case 5:
                    Course course= new Course("Java",9, LocalDate.of(2022,10,1), "https://vt.photo.com","backend");
                    Course course1= new Course("JavaScript",6, LocalDate.of(2022,3,25), "https://vt.photo.com","frontend");
                    Course course2= new Course("Java",4, LocalDate.of(2023,2,9), "https://vt.photo.com","backend");
                    System.out.println(courseService.saveCourse(course2));
                    break;
                case 11:
                    Lesson lesson=new Lesson("Hibernate","https://vt.video.com");
                    Lesson lesson1=new Lesson("JDBC","https://vt.video.com");
                    Lesson lesson2=new Lesson("GITHUB","https://vt.video.com");
                    Lesson lesson3=new Lesson("RelationShip","https://vt.video.com");
                    System.out.println(lessonService.saveLesson(2L,lesson3));
                    break;
                case 15:
                    Instructor instructor=new Instructor("Aijamal","Asangazieva",
                            "a@gmail.com","0990128880");
                    Instructor instructor1=new Instructor("Muhammed ","Toichubai uul",
                            "m@gmail.com","0223628889");
                    Instructor instructor2=new Instructor("Rahim","Bazarbai uulu",
                            "r@gmail.com","0990134829");

                    System.out.println(instructorService.saveInstructor(instructor1));
                    break;
                case 6:
                    System.out.println(courseService.getCourseById(2L));
                    break;
                case 17:
                    System.out.println(instructorService.getInstructorById(3L));
                    break;
                case 13:
                    System.out.println(lessonService.getLessonById(5L));
                    break;
                case 7:
                    System.out.println(courseService.getAllCoursesSortByCreateAt("desc"));
                    break;
                case 8:
                    System.out.println(courseService.updateCourse(3L, new Course("JavaScript", 3,
                            LocalDate.of(2023, 1, 25), "https://vttk.photo.com",
                            "frontend")));
                    break;
                case 12:
                    System.out.println(lessonService.updateLesson(1L, new Lesson("Cascade Type",
                            "https://vttt.video.com")));
                    break;
                case 2:
                    System.out.println(taskService.updateTask(3L, new Task("20:45", "task-enums")));
                    break;
                case 9:
                    System.out.println(courseService.deleteCourseById(3L));
                    break;
                case 10:
                    System.out.println(courseService.getCourseByName("Java"));
                    break;
                case 19:
                    System.out.println(instructorService.deleteInstructorById(2L));
                    break;
                case 16:
                    System.out.println(instructorService.updateInstructor(3L,
                            new Instructor("Maksat ", "Akylbek uulu",
                            "maksat@gmail.com", "0702666357")));
                    break;
                case 20:
                    instructorService.assignInstructorToCourse(1L,1L);
                    break;
                case 18:
                    System.out.println(instructorService.getInstructorsByCourseId(1L));
                    break;
                case 14:
                    System.out.println(lessonService.getLessonsByCourseId(2L));
                    break;
                case 3:
                    System.out.println(taskService.getAllTasksByLessonId(3L));
                    break;
                case 4:
                    System.out.println(taskService.deleteTaskById(5L));
                    break;


            }
        }
    }
}
