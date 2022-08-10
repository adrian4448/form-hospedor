import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './form/form.component';
import { FormPageComponent } from './pages/form-page/form-page.component';

@NgModule({
  declarations: [
    FormComponent,
    FormPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class GetFormModule { }
