package com.hibernate.handson.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "answer_one_to_many")
public class AnswerOtoM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;

    private String answer;

    @ManyToOne
    //@JoinColumn(name = "question_id")
    private QuestionOtoM question;
}
