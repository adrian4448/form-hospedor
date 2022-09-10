import { Component, OnInit } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { UploaderService } from '../services/uploader.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(
    private uploaderService: UploaderService,
    private messageService: MessageService
  ) { }

  public items: MenuItem[] = [];
  public activeItem = 0;
  
  public siteName: string = '';
  public siteUrl: string = '';

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

  firstStep() {
    this.activeItem = 0;
    this.siteName = '';
    this.siteUrl = '';
  }

  uploadSite(event: any) {
    const formData: FormData = new FormData();
    const siteFile = event.files[0]; 
    formData.append('file', siteFile);

    this.uploaderService.uploadFile(this.siteName, formData).subscribe(res => {
      this.siteUrl = res.urlSigned;
      this.nextStep();
    }, err => {
      this.messageService.add({ severity:'error', summary:'Erro', detail:`Ocorreu um problema ao fazer o upload do site erro: ${err.error.errors[0]}` });
    });
  }
}
