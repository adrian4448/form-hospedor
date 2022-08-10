import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AwsPageComponent } from './aws-page.component';

describe('AwsPageComponent', () => {
  let component: AwsPageComponent;
  let fixture: ComponentFixture<AwsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AwsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AwsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
