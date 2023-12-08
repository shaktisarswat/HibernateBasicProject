package com.hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OneToManyMappingQuestion {
    @Id
    private int questionId;
    private String question;
    @OneToMany
    private List<ManyToOneAnswer> answers;

    public OneToManyMappingQuestion() {
    }

    public OneToManyMappingQuestion(int questionId, String question, List<ManyToOneAnswer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ManyToOneAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ManyToOneAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "ManyToOneMappingQuestion{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
