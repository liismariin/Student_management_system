package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StudentResults {
    @Id
    @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Course course;
    @OneToOne
    private Student student;

    @Column(name = "grade")
    private GRADE grade;

}


