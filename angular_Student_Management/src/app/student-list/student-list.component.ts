import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from "../student"
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[];

  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentsList().subscribe({
      next: data => {
        this.students = data;
      },
      error: error => {
        console.error(error);
      }
    });
  }

  updateStudent(id: number) {
    this.router.navigate(['update-student', id]);
  }

}
