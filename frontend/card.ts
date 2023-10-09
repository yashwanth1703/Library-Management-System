import { Book } from "./Book";
import { User } from "./User";

export class card{
    id:number;
    user():User{
     throw new Error("Method not implemented");
   }
   books():Book{
    throw new Error("Method not implemented")
   }
}
export enum CardStaus{
    activated="ACTIVATED",
    deactivated="DEACTIVATED"
}
export const cardStatus={
    [CardStaus.activated]:"Activated",
    [CardStaus.deactivated]:"Deactivated",
}