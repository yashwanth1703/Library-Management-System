import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { VeiwBookComponent } from './veiw-book/veiw-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { SignInComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ContactComponent } from './contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AuthorsComponent } from './authors/authors.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { CardComponent } from './card/card.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { ViewAuthorComponent } from './view-author/view-author.component';
import { FeedBackListComponent } from './feed-back-list/feed-back-list.component';
import { AddFeedbackComponent } from './add-feedback/add-feedback.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UsersComponent } from './users/users.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { ViewCardComponent } from './view-card/view-card.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    CreateBookComponent,
    VeiwBookComponent,
    UpdateBookComponent,
    SignInComponent,
    SignupComponent,
    ContactComponent,
    AboutUsComponent,
    AuthorsComponent,
    AddAuthorComponent,
    CardComponent,
    FeedbackComponent,
    UpdateAuthorComponent,
    ViewAuthorComponent,
    FeedBackListComponent,
    AddFeedbackComponent,
    ViewFeedbackComponent,
    TransactionComponent,
    
    UpdateUserComponent,
    UsersComponent,
    ViewUserComponent,
    ViewCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
