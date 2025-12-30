import { Component, CUSTOM_ELEMENTS_SCHEMA, signal } from '@angular/core';
import { ApiService } from './api.service';
import { Customer } from './customer/customer';

@Component({
  selector: 'app-root',
  imports: [Customer],
  templateUrl: './app.html',
  styleUrl: './app.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class App {
  customerData : any[] = [];
  constructor(private api: ApiService){}
  ngOnInit(){
    this.api.getCustomers().subscribe(res => {
      console.log(res);
      this.customerData = res;
    })
  }
}
