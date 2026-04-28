import { Component,ViewChild } from '@angular/core';
import { EmployeeComponent } from './employee/employee.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  data = "Data from Parent Component Employee Name : John Doe";

  @ViewChild(EmployeeComponent) employee!: EmployeeComponent;

  ngAfterViewInit() {
   console.log("Accessing Employee Component from Parent Component: ", this.employee);
    this.employee.getEmployeeDetails();
    this.employee.
  }

}
