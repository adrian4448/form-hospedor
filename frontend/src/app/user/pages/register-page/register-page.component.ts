import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(
    private userService: UserService,
    private messageService: MessageService,
    private router: Router
  ) { }

  public passwordConfirm = '';

  public userForm = new FormGroup({
    userName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl('')
  })

  ngOnInit(): void {
  }

  public register() {
    const { userName, password, email, confirmPassword } = this.userForm.value;

    if (password !== confirmPassword) {
      this.messageService.add({ severity:'error', summary:'Erro', detail:'Informe senhas iguais para cadastrar o usuário' });
      return;
    }

    this.userService.registerUser({ userName, password, email }).subscribe(res => {
      this.router.navigate(['/login']);
    }, e => {
      this.messageService.add({ severity:'error', summary:'Erro', detail: `Não foi possivel registrar o usuário, verifique as informações. Error: ${e.error.errors[0]}` });
    });
  }

}
