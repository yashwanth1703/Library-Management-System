import { Author } from "./Author";
import { card } from "./card";


export class Book{
     
    authorsBook():Author{
      throw new Error("Method not Implemented")
    }
    card():card{
      throw new Error("Method not Implemented")
    }
   
    bookISBN : number=0;
    bookName : string="";
    author : string="";
    noOfBooks : number=0;
    bookCost : number=0;
    isPublished : boolean=false;
    ratingOfBook : number=0;
    categoryDetails:string="";

    

}

