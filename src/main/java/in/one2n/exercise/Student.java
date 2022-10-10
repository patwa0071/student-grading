package in.one2n.exercise;

import java.util.Objects;

public class Student {

    private String firstname;
    private String lastname;
    private String university;
    private Double test1Score;
    private Double test2Score;
    private Double test3Score;
    private Double test4Score;

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getUniversity() {
        return university;
    }
    public Double getTest1Score() {
        return test1Score;
    }
    public Double getTest2Score() { return test2Score; }
    public Double getTest3Score() {
        return test3Score;
    }
    public Double getTest4Score() {
        return test4Score;
    }

    // computed fields
    private Double finalScore;
    private Grade grade;
    public Student(){

    }
    public Student(String firstname, String lastname, String university) {
        // TODO: add your implementation here
        this.firstname=firstname;
        this.lastname=lastname;
        this.university=university;
    }
    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
        // TODO: add your implementation here
        this.firstname=firstname;
        this.lastname=lastname;
        this.university=university;
        this.test1Score=test1Score;
        this.test2Score=test2Score;
        this.test3Score=test3Score;
        this.test4Score=test4Score;
    }
    public Double getFinalScore() {
        // TODO: add your implementation here
        return this.finalScore;
    }

    public Grade getGrade() {
        // TODO: add your implementation here
        return this.grade;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(university, student.university) && Objects.equals(test1Score, student.test1Score) && Objects.equals(test2Score, student.test2Score) && Objects.equals(test3Score, student.test3Score) && Objects.equals(test4Score, student.test4Score) && Objects.equals(finalScore, student.finalScore) && grade == student.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, university, test1Score, test2Score, test3Score, test4Score, finalScore, grade);
    }

}

