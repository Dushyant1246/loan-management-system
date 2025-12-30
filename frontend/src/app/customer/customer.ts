import { Component, Input } from '@angular/core';
import { DatePipe } from '@angular/common';
import { CustomerModel } from './customer.model';

@Component({
  selector: 'tr[app-customer]',
  imports: [DatePipe],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
})
export class Customer {
  @Input({required: true}) customer!: CustomerModel;
}
