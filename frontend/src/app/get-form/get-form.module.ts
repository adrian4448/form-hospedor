import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './form/form.component';
import { FormPageComponent } from './pages/form-page/form-page.component';
import { InputTextModule } from 'primeng/inputtext';
import { FileUploadModule } from 'primeng/fileupload';
import { HttpClientModule } from '@angular/common/http';
import { StepsModule } from 'primeng/steps';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';

@NgModule({
  declarations: [
    FormComponent,
    FormPageComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    FileUploadModule,
    StepsModule,
    HttpClientModule,
    CardModule,
    ButtonModule
  ]
})
export class GetFormModule { }
