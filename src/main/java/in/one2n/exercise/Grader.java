package in.one2n.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grader {

    public List<Student> parseCSV(String filepath) throws IOException {
        // TODO: add your implementation here
        List <Student> studentList = new ArrayList <>();
        String line ;

        // Read all lines in from CSV file and add to studentList
        FileReader fileReader = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i=0;
        while ((line = bufferedReader.readLine()) != null) {
            if(i==0) {
                i++;
                continue;
            }
            String[] temp = line.split(",");

            String firstname = temp[0];
            String lastname = temp[1];
            String university= temp[2];
            Double test1Score= Double.parseDouble(temp[3]);
            Double test2Score= Double.parseDouble(temp[4]);
            Double test3Score= Double.parseDouble(temp[5]);
            Double test4Score= Double.parseDouble(temp[6]);
            studentList.add(new Student(firstname,lastname,university,test1Score,test2Score,test3Score,test4Score));
        }
        bufferedReader.close();
        return studentList;
    }

    public List<Student> calculateGrade(List<Student> students) {
        // TODO: add your implementation here
        List<Student> gradedStudents=new ArrayList<>();
        for(Student student:students){
            Double finalScore= (student.getTest1Score()+ student.getTest2Score()+ student.getTest3Score()+ student.getTest4Score())/4;
            student.setFinalScore(finalScore);
            if(finalScore<35){
                student.setGrade(Grade.F);
            } else if (finalScore>=35 && finalScore<50) {
                student.setGrade(Grade.C);
            } else if (finalScore>=50 && finalScore<70) {
                student.setGrade(Grade.B);
            }
            else
                student.setGrade(Grade.A);
            gradedStudents.add(student);
        }
        return gradedStudents;
    }

    public Student findOverallTopper(List<Student> gradedStudents) {
        // TODO: add your implementation here
        Double topperScore=Double.MIN_VALUE;
        Student topperStudent=new Student();
        for(Student student:gradedStudents){
            if(student.getFinalScore()>topperScore){
                topperScore= student.getFinalScore();
                topperStudent=student;
            }
        }
        return new Student(topperStudent.getFirstname(), topperStudent.getLastname(), topperStudent.getUniversity());
    }

    public Map<String, Student> findTopperPerUniversity(List<Student> gradedStudents) {
        // TODO: add your implementation here
        Map<String, Student> finalTopper = new HashMap<>();
        Map<String,Student> topperPerUniversity=new HashMap<>();
        for(Student student:gradedStudents){
            if (topperPerUniversity.get(student.getUniversity())!=null) {
                if(student.getFinalScore()>topperPerUniversity.get(student.getUniversity()).getFinalScore()){
                    topperPerUniversity.put(student.getUniversity(), student);
                }
            }
            else{
                topperPerUniversity.put(student.getUniversity(), student);
            }
        }
        for(Map.Entry<String, Student> topper :topperPerUniversity.entrySet()){
            Student student = topper.getValue();
            finalTopper.put(student.getUniversity(), new Student(student.getFirstname(), student.getLastname(), student.getUniversity()));
        }
        return finalTopper;
    }
}
