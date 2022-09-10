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
import { FormsModule } from '@angular/forms';
import { UploaderService } from './services/uploader.service';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';

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
    ButtonModule,
    FormsModule,
    ToastModule
  ],
  providers: [UploaderService, MessageService]
})
export class GetFormModule { }
