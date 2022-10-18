import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderComponent } from './header/header.component';
import { UserComponent } from './user/user.component';
import { RegistrationComponent } from './user/registration/registration.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserService } from './services/user.service';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UserComponent,
    RegistrationComponent,
  ],
  imports: [HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BackButtonDisableModule.forRoot()
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
