import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {
   @Input() emp_data!:string;
   title = "from Employee Component ";

   employee = {
    name: "John Doe",
    age: 30,
    position: "Software Engineer"
   }
   getEmployeeDetails(){
    console.log("Employee Component Details: ", this.employee);
   }
   
}
