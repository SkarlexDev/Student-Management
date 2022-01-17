package net.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.model.Student;
import net.service.StudentService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("students/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {

		return studentService.getStudentByID(id);

	}
	
	@PutMapping("students/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student studentNew) {
		studentService.updateStudent(id,studentNew);
	}
}
