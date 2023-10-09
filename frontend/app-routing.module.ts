import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { VeiwBookComponent } from './veiw-book/veiw-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { SignInComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuardService } from './auth-guard.service';
import { ContactComponent } from './contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AuthorsComponent } from './authors/authors.component';
import { AddAuthorComponent } from './add-author/add-author.component';
import { CardComponent } from './card/card.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ViewAuthorComponent } from './view-author/view-author.component';
import { UpdateAuthorComponent } from './update-author/update-author.component';
import { FeedBackListComponent } from './feed-back-list/feed-back-list.component';
import { AddFeedbackComponent } from './add-feedback/add-feedback.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';

import { UpdateUserComponent } from './update-user/update-user.component';
import { UsersComponent } from './users/users.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { ViewCardComponent } from './view-card/view-card.component';

const routes: Routes = [
  {path: 'library', component: BookListComponent,canActivate:[AuthGuardService]},
  {path: 'create-Book', component: CreateBookComponent,canActivate:[AuthGuardService]},
  {path:  'veiw-book-details/:id',component:VeiwBookComponent,canActivate:[AuthGuardService]},
  {path:  'update-book/:id',component:UpdateBookComponent,canActivate:[AuthGuardService]},
  {path: 'sign-in',component:SignInComponent},
  {path: 'sign-up',component:SignupComponent},
  {path: 'contact-us',component:ContactComponent},
  {path:'About-us',component:AboutUsComponent},
  {path:'authors',component:AuthorsComponent,canActivate:[AuthGuardService]},
  {path:'Add-Author',component:AddAuthorComponent,canActivate:[AuthGuardService]},
  {path:'card',component:CardComponent,canActivate:[AuthGuardService]},
  {path:'feedback',component:FeedbackComponent},
  {path:'view-author/:id',component:ViewAuthorComponent,canActivate:[AuthGuardService]},
  {path:'update-author/:id',component:UpdateAuthorComponent,canActivate:[AuthGuardService]},
  {path:'feed-back-list',component:FeedBackListComponent,canActivate:[AuthGuardService]},
  {path: 'view-feedback/:id',component:ViewFeedbackComponent,canActivate:[AuthGuardService]},
  {path: 'add-feedback/:id',component:AddFeedbackComponent,canActivate:[AuthGuardService]},
  {path :'view-user/:id',component:ViewUserComponent,canActivate:[AuthGuardService]},
  {path:'update-user/:id',component:UpdateUserComponent,canActivate:[AuthGuardService]},
  {path:'users',component:UsersComponent,canActivate:[AuthGuardService]},
  {path:'view-card-details/:id',component:ViewCardComponent,canActivate:[AuthGuardService]},
  {path:'cards',component:CardComponent,canActivate:[AuthGuardService]}
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
