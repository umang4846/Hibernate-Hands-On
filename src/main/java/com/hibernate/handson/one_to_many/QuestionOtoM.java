package com.hibernate.handson.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "question_one_to_many")
public class QuestionOtoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question")
    @Column(name = "answer_id")
    //@JoinColumn(name = "answer_id")
    private List<AnswerOtoM> answers;
}
