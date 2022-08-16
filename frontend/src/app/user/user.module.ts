import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    RegisterComponent,
    RegisterPageComponent,
    LoginPageComponent
  ],
  imports: [
    CommonModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [LoginService]
})
export class UserModule { }
