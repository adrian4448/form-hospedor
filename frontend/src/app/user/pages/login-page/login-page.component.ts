import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService: LoginService,
    private cookieService: CookieService) { }

  userForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl('')
  })

  ngOnInit(): void {
  }

  login() {
    const { userName, password } = this.userForm.value;

    this.loginService.authUser({ userName, password }).subscribe(res => {
      this.cookieService.set('userLogged', JSON.stringify(res));
    });
  }

}
