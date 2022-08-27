import { Component, DoCheck, OnChanges, SimpleChanges } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  template: `
    <app-menu *ngIf="userLogged"></app-menu>
    <router-outlet></router-outlet>
    <app-footer></app-footer>
  `
})
export class AppComponent implements DoCheck {

  constructor(private cookieService: CookieService) {}

  userLogged: any = null;

  ngDoCheck(): void {
    this.userLogged = this.cookieService.get('userLogged')
  }

}
