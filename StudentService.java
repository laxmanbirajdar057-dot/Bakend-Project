package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        return repository.findById(id).map(s -> {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setCourse(student.getCourse());
            return repository.save(s);
        }).orElse(null);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
