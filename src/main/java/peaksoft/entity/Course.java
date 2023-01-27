package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="courses")
@Getter
@Setter
@ToString(exclude = {"lessons","instructors"})

@NoArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "course_id_generator")
    @SequenceGenerator(name = "course_id_generator",
    sequenceName = "course_seq",
    allocationSize = 1)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private int duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "image_link")
    private String imageLink;
    private String description;

    @OneToMany(mappedBy = "course",cascade = {CascadeType.DETACH,CascadeType.
            MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})  //bi
    private List<Lesson> lessons;
    @ManyToMany(mappedBy = "courses",cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Instructor>instructors;


    public Course(String courseName, int duration, LocalDate createAt,
                  String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;

    }

    public Course(String courseName, int duration, LocalDate createAt,
                  String imageLink, String description, List<Instructor> instructors) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
        this.instructors = instructors;
    }
}

