import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AwsSignComponent } from './aws-sign.component';

describe('AwsSignComponent', () => {
  let component: AwsSignComponent;
  let fixture: ComponentFixture<AwsSignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AwsSignComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AwsSignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
