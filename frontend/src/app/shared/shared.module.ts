import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuModule } from './menu/menu.module';
import { UtilsService } from './services/UtilsService';
import { FooterModule } from './footer/footer.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MenuModule,
    FooterModule
  ],
  providers: [ UtilsService ]
})
export class SharedModule { }
