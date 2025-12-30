import { Component} from '@angular/core';
import { ApiService } from './api.service';
import { Customer } from './customer/customer';
import { Header } from "./header/header";
import { LoanApplication } from './loan-application/loan-application';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-root',
  imports: [Header, LoanApplication],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  loanApplicationData : any[] = [];
  constructor(private api: ApiService, private cd: ChangeDetectorRef){}
  ngOnInit(): void{
    this.api.getLoanApplications().subscribe(res => {
      this.loanApplicationData = res.content;
      this.cd.markForCheck();
      console.log(res);
    })
  }
}
