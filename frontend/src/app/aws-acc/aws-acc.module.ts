import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AwsSignComponent } from './aws-sign/aws-sign.component';
import { AwsPageComponent } from './pages/aws-page/aws-page.component';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { AwsAccountService } from './aws-sign/services/aws-account.service';

@NgModule({
  declarations: [
    AwsSignComponent,
    AwsPageComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    ButtonModule,
    HttpClientModule,
  ],
  providers: [ AwsAccountService ]
})
export class AwsAccModule { }
