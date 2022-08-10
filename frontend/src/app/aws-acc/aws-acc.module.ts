import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AwsSignComponent } from './aws-sign/aws-sign.component';
import { AwsPageComponent } from './pages/aws-page/aws-page.component';



@NgModule({
  declarations: [
    AwsSignComponent,
    AwsPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AwsAccModule { }
