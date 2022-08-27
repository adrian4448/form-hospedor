import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { SharedModule } from 'primeng/api';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AwsAccModule } from './aws-acc/aws-acc.module';
import { GetFormModule } from './get-form/get-form.module';
import { JwtInterceptor } from './shared/interceptors/JwtInterceptor';
import { MenuModule } from './shared/menu/menu.module';
import { UserModule } from './user/user.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FooterModule } from './shared/footer/footer.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    MenuModule,
    GetFormModule, 
    AwsAccModule,
    UserModule,
    BrowserAnimationsModule,
    FooterModule,
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
