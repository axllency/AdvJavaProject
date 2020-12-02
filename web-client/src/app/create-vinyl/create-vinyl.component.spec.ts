import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVinylComponent } from './create-vinyl.component';

describe('CreateVinylComponent', () => {
  let component: CreateVinylComponent;
  let fixture: ComponentFixture<CreateVinylComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateVinylComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateVinylComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
