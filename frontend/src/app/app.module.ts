import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AwsAccModule } from './aws-acc/aws-acc.module';
import { GetFormModule } from './get-form/get-form.module';
import { MenuModule } from './shared/menu/menu.module';
import { UserModule } from './user/user.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenuModule,
    GetFormModule, 
    AwsAccModule,
    UserModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
