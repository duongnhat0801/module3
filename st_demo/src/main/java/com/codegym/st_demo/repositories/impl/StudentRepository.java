package com.codegym.st_demo.repositories.impl;

import com.codegym.st_demo.models.Student;
import com.codegym.st_demo.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L, "haiTT", "QN", 10.0f));
        students.add(new Student(2L, "Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L, "Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L, "Cook", "Bàn ăn", 2f));
    }

    private Student student;

    @Override
    public List<Student> findAll() {
//        List<Student> list = Collections.addAll(students);

        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student updatedStudent) {
        for (Student existingStudent : students) {
            if (existingStudent.getId().equals(student.getId())) {
                existingStudent.setName(student.getName());
                existingStudent.setAddress(student.getAddress());
                existingStudent.setPoint(student.getPoint());
                return;
            }
        }
    }
    @Override
    public List<Student> findByName(String name) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }

}
