export interface CustomerModel{
    fullName: string;
    email: string;
    phone: string;
    dob: Date;
    kycStatus: KycStatus;
    id: string;
}

export type KycStatus = 'PENDING' | 'VERIFIED' | 'REJECTED';