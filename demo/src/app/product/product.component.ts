import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: any[] = [];
constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('https://redesigned-orbit-4j4xvgg99xrh7779-8080.app.github.dev/')
      .subscribe(data => {
        this.products = data;
        console.log("✅ Products loaded:", data.length);
      });
  }

}
