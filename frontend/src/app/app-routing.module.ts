import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AwsPageComponent } from './aws-acc/pages/aws-page/aws-page.component';
import { FormPageComponent } from './get-form/pages/form-page/form-page.component';

const routes: Routes = [
  { path: 'form', component: FormPageComponent },
  { path: 'aws', component: AwsPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
