import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVinylComponent } from './update-vinyl.component';

describe('UpdateVinylComponent', () => {
  let component: UpdateVinylComponent;
  let fixture: ComponentFixture<UpdateVinylComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateVinylComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateVinylComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
