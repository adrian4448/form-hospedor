import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { MessageService } from 'primeng/api';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(
    private loginService: LoginService,
    private cookieService: CookieService,
    private router: Router,
    private messageService: MessageService
  ) { }

  userForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl('')
  })

  ngOnInit(): void {
    this.cookieService.deleteAll();
  }

  login() {
    const { userName, password } = this.userForm.value;

    this.loginService.authUser({ userName, password }).subscribe(res => {
      this.cookieService.set('userLogged', JSON.stringify(res));
      this.router.navigate(['/form']);
    }, error => {
      this.messageService.add({ severity:'error', summary:'Erro', detail:'Usuário ou senha incorretos, tente novamente' });
    });
  }

}
