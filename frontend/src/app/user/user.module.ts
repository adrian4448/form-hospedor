import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { RegisterComponent } from './register/register.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';



@NgModule({
  declarations: [
    SignInComponent,
    RegisterComponent,
    ProfilePageComponent,
    RegisterPageComponent,
    LoginPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
