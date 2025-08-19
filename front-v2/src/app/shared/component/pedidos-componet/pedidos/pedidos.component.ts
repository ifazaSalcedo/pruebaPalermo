import { ChangeDetectionStrategy, Component } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { PedidosdetComponent } from "../pedidosdet/pedidosdet.component";
import { NgIf } from '@angular/common';
import { AddproductoComponent } from "../addproducto/addproducto.component";
import { Pedido } from '../../../model/pedido-model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [FormsModule, MatInputModule, MatSelectModule, MatDatepickerModule, MatButtonModule, MatDividerModule, MatIconModule, PedidosdetComponent, NgIf, AddproductoComponent],
  providers: [provideNativeDateAdapter()],
  templateUrl: './pedidos.component.html',
  styleUrl: './pedidos.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PedidosComponent {

  scena: 'pedidos' | 'add-product' = 'pedidos';

  pedido : Pedido = {
    id: 3156444,
    fecha: new Date(),
    total: '0',
    clienteId: '2236245',
    clienteNombre: 'Cliente de prueba',

  }



  goPedido(){
    this.scena = 'pedidos';
  }

  goAddProduct() {
    this.scena = 'add-product';
  }

  onAddProduct() {
    this.scena = 'add-product';
  }

}
