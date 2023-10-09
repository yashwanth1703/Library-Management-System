import { Book } from "./Book";
import { User } from "./User";
export class feedback{

    book():Book{
        throw new Error(" method not implemented ");
    }
    user():User{
        throw new Error("method not implemented");
    }

    feedBackId:number;
    bookRating:any
    overallRating:any
    comments:any
    
    
}