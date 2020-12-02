import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindVinylComponent } from './find-vinyl.component';

describe('FindVinylComponent', () => {
  let component: FindVinylComponent;
  let fixture: ComponentFixture<FindVinylComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindVinylComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindVinylComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
