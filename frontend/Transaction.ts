


export class Transaction{


    transactionId:number=0;
    fineAmount:number=0;
    issueDate:any;
    constructor(public status:string){}

}
enum transactionStatus{
    successful="SUCCESSFULL",
    pending="PENDING",
    failed="FAILED"
}
export const StatusLabelling={
[transactionStatus.successful]:"successfull",
[transactionStatus.pending]:"pending",
[transactionStatus.failed]:"failed"
}