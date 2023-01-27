package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString(exclude = {"course","tasks"})
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "lesson_id_generator")
    @SequenceGenerator(name = "lesson_id_generator",
    sequenceName = "lesson_seq",
    allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "video_link")
    private String videoLink;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Task>tasks;  //uni

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;

    }
}

