export interface LoanApplicationModel{
    
    customerName: string;
    requestedAmount: number;
    requestedTenureMonths: number;
    proposedRate?: number;
    status: 'SUBMITTED' | 'APPROVED' | 'REJECTED' | 'UNDER_REVIEW';
    decisionNotes?: string;
    submittedAt: Date;
    decidedAt?: Date; 

}