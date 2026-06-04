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

   employees = [
    { name: "Alice Smith", age: 28, position: "UI/UX Designer" },
    { name: "Bob Johnson", age: 35, position: "Project Manager" },
    { name: "Charlie Brown", age: 25, position: "QA Engineer" }
   ]
   getEmployeeDetails(){
    console.log("Employee Component Details: ", this.employee);
   }
   
}
