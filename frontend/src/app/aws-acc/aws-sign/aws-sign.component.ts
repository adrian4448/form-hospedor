import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { AwsAccountService } from './services/aws-account.service';

@Component({
  selector: 'app-aws-sign',
  templateUrl: './aws-sign.component.html',
  styleUrls: ['./aws-sign.component.css']
})
export class AwsSignComponent implements OnInit {

  public awsInfoForm = new FormGroup({
    accessKey: new FormControl(''),
    secretKey: new FormControl('')
  })


  constructor(
    private awsAccountInfoService: AwsAccountService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.awsAccountInfoService.findAwsAccountInfoByUser().subscribe(resp => {
      this.awsInfoForm = new FormGroup({
        accessKey: new FormControl(resp.accessKey),
        secretKey: new FormControl(resp.secretKey)
      })
    });
  }

  createNewAwsInfo() {
    const { accessKey, secretKey } = this.awsInfoForm.value;
    this.awsAccountInfoService.createAwsAccountInfo({ accessKey, secretKey}).subscribe(() => {
      this.messageService.add({ severity:'success', summary:'Sucesso', detail:'Informações salvas com sucesso' });
    });
  }

}
