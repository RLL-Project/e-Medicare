import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { RegistrationComponent } from './user/registration/registration.component';
import { UserComponent } from './user/user.component';


const routes: Routes = [
 {path:"header", component:HeaderComponent},
 { path: "", redirectTo: 'user', pathMatch: 'full' },
  {path:"user", component:UserComponent},
  {path:"registration", component:RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
