import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor() { }

  public items: MenuItem[] = [];

  public activeItem = 0;

  ngOnInit() {
    this.items = [
      { label: 'Dados do site' },
      { label: 'Fazer Upload do arquivo' },
      { label: 'Finalizar' }
    ];
  }

  nextStep() {
    this.activeItem++;
  }

  previousStep() {
    this.activeItem--;
  }
}
