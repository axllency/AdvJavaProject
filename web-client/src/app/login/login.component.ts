import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: any;
  password: any;

  login: Boolean;

  constructor(private router: Router,private loginService: AuthenticationService) { }

  ngOnInit(): void {
  }

  checklogin(){
    this.loginService.authenticate(this.username,this.password).subscribe(
      data =>{
        this.login = true
        this.router.navigate(['/find'])
      },
      error => {
        this.login = false
      }
    )
  }

}
