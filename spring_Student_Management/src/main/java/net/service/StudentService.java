package net.service;

import net.model.Student;
import net.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Optional<Student> getStudentByID(long id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long id,Student studentNew) {
		Student student = studentRepository.findById(id).get();
		student.setFirstname(studentNew.getFirstname());
		student.setLastname(studentNew.getLastname());
		student.setEmail(studentNew.getEmail());
		
		return studentRepository.save(student);
	}
	
}
