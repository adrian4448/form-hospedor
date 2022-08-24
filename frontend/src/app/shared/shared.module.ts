import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuModule } from './menu/menu.module';
import { UtilsService } from './services/UtilsService';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MenuModule
  ],
  providers: [ UtilsService ]
})
export class SharedModule { }
