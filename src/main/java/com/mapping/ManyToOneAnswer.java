package com.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ManyToOneAnswer {
    @Id
    private int answerId;
    private String answer;
    @ManyToOne
    private OneToManyMappingQuestion question;

    public ManyToOneAnswer() {
    }

    public ManyToOneAnswer(int answerId, String answer, OneToManyMappingQuestion question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public OneToManyMappingQuestion getQuestion() {
        return question;
    }

    public void setQuestion(OneToManyMappingQuestion question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "OneToManyAnswer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
