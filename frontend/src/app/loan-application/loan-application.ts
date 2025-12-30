import { Component, Input } from '@angular/core';
import { DatePipe } from '@angular/common';
import { LoanApplicationModel } from './loan-application.model';

@Component({
  selector: '[app-loan-application]',
  imports: [DatePipe],
  templateUrl: './loan-application.html',
  styleUrl: './loan-application.css',
})
export class LoanApplication {
  @Input({required:true}) loan_application !: LoanApplicationModel;
}
