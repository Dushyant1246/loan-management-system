import { Component, Input } from '@angular/core';
import { CustomerModel } from './customer.model';

@Component({
  selector: 'tr[app-customer]',
  imports: [],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
})
export class Customer {
  @Input({required: true}) customer: any;
}
