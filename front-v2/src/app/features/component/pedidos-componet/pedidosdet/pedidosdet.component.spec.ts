import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidosdetComponent } from './pedidosdet.component';

describe('PedidosdetComponent', () => {
  let component: PedidosdetComponent;
  let fixture: ComponentFixture<PedidosdetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PedidosdetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PedidosdetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
