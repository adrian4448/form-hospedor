import { NgModule } from "@angular/core";
import { MenuComponent } from "./menu.component";
import { MenubarModule } from 'primeng/menubar';

@NgModule({
    declarations: [
      MenuComponent,
    ],
    imports: [
      MenubarModule,
    ],
    exports: [
        MenuComponent,
    ],
    providers: []
  })
export class MenuModule {

}