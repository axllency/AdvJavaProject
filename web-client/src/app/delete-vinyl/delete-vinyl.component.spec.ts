import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteVinylComponent } from './delete-vinyl.component';

describe('DeleteVinylComponent', () => {
  let component: DeleteVinylComponent;
  let fixture: ComponentFixture<DeleteVinylComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteVinylComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteVinylComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
