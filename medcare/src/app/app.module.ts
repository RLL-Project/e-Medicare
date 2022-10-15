import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { AddmedicineComponent } from './adminpage/addmedicine/addmedicine.component';
import { UpdatemedicineComponent } from './adminpage/updatemedicine/updatemedicine.component';
import { AdmindashComponent } from './admindash/admindash.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminloginComponent,
    AdminpageComponent,
    AddmedicineComponent,
    UpdatemedicineComponent,
    AdmindashComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
