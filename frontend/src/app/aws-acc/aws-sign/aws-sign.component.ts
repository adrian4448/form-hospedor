import { Component, OnInit } from '@angular/core';
import { AwsAccountService } from './services/aws-account.service';

@Component({
  selector: 'app-aws-sign',
  templateUrl: './aws-sign.component.html',
  styleUrls: ['./aws-sign.component.css']
})
export class AwsSignComponent implements OnInit {

  constructor(
    private awsAccountInfoService: AwsAccountService
  ) { }

  ngOnInit(): void {
  }

}
