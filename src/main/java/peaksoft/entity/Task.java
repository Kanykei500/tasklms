package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "task_id_generator")
    @SequenceGenerator(name = "task_id_generator",
    sequenceName = "task_seq",
    allocationSize = 1)

    private Long id;
    @Column(name = "dead_line")
    private String deadLine;
    private String task;

    public Task(String deadLine, String task) {
        this.deadLine = deadLine;
        this.task = task;
    }
}
