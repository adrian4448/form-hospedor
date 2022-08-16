import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor() { }

  public items: MenuItem[] = [];

  public userLogged = localStorage.getItem('userLogged');

  ngOnInit() {
    this.items = [
        {
          label: 'Hospedar Site',
          icon: 'pi pi-fw pi-code',
          url: '/form'
        },
        { 
          label: 'Sites hospedados',
          icon: 'pi pi-server',
        },
        {
          label: 'Informações AWS',
          icon: 'pi pi-fw pi-amazon',
          url: '/aws'
        },
        {
          label: 'Sair',
          icon: 'pi pi-power-off',
          url: '/login'
        }
    ];
}

}
