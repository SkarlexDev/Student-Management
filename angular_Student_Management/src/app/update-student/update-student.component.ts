import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  id: number;
  student: Student = new Student();
  constructor(private studentService: StudentService,
    private route: ActivatedRoute, private router: Router) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe({
      next: data => {
        this.student = data;
      },
      error: error => {
        console.error(error);
      }
    });
  }

  onSubmit(): void {
    this.studentService.updateStudent(this.id, this.student).subscribe({
      next: () => {
        this.redirectToStudentList();
      },
      error: error => {
        console.error(error);
      }
    });
  }

  redirectToStudentList() {
    this.router.navigate(['/students']);
  }
}
