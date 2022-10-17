import { Component, OnInit } from '@angular/core';
import { AuthenticationStatus } from '../authentication-status/authentication-status.module'; 
import { Router} from '@angular/router';
import { LoginService } from '../login.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  authStatus: AuthenticationStatus | undefined;
  constructor(
    private userservice:LoginService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    console.log(form.value.username, form.value.password);

    this.userservice
    .authenticate(form.value.username, form.value.password)
    .subscribe((res) => {
      this.authStatus = res;
      if (this.authStatus.authenticated) {
        alert("Successfully logged in!")
        //Swal.fire('Log-In Suceessful !!');
        //this.router.navigate(['/userpage'], {relativeTo: this.route});
      }
      else {
       /* Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Invalid Credentials - Try Again',
        })*/
        alert("Invalid Credentials!")
        //this.router.navigate(['/user'], { relativeTo: this.route});
        form.reset();
}
});
}


}
