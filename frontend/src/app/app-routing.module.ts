import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AwsPageComponent } from './aws-acc/pages/aws-page/aws-page.component';
import { FormPageComponent } from './get-form/pages/form-page/form-page.component';
import { LoginPageComponent } from './user/pages/login-page/login-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginPageComponent },
  { path: 'form', component: FormPageComponent },
  { path: 'aws', component: AwsPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
