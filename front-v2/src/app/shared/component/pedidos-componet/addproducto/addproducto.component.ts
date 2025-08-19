import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { Producto, PRODUCTOS_DATA } from '../../../model/producto-model';
import { ProductoListaPrecio } from '../../../model/producto-lista-precio-model';
import { PedidoService } from '../service/pedido.service';
import { isTemplateExpression } from 'typescript';
import { PedidoDetalle } from '../../../model/pedido-detalle-model';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-addproducto',
  imports: [FormsModule, MatTableModule, MatButtonModule,
    MatDividerModule,  CommonModule, CurrencyPipe,
    MatIconModule, MatCardModule, MatFormFieldModule,
    MatInputModule],
  templateUrl: './addproducto.component.html',
  styleUrl: './addproducto.component.css'
})
export class AddproductoComponent {


  displayedColumns: string[] = ['position', 'symbol'];
  productos = PRODUCTOS_DATA;
  clickedRows = new Set<PeriodicElement>();

  @Output() retrunPedido= new EventEmitter<void>();


  constructor(private pedidoService: PedidoService){

  }

  onReturnPedido(){
    this.retrunPedido.emit();
  }

  onGrabar(){

    this.pedidoService.removeAllProducto();

    this.productos
      .filter((prod: Producto) => (prod.cantidaPedido ?? 0) > 0)
      .forEach((prod: Producto) => {
        const detalle: PedidoDetalle  = {
          item: 1,
          productoId: prod.id,
          producto: prod,
          cantidad: prod.cantidaPedido!,
          precioUnitario: prod.precio,
          total: prod.total
        };
        this.pedidoService.addProducto(detalle);
      })

      this.onReturnPedido();


  }

  onAumentarCantidadEvent(element: any) {
    if (element.cantidaPedido === undefined) {
      element.cantidaPedido = 0;
      element.total = 0;
      return
    }
    element.cantidaPedido++;

    this.calculateTotal(element);
  }

  onDisminuirCantidadEvent(element: any) {
    if (element.cantidaPedido === undefined) {
      element.cantidaPedido = 0;
      element.total = 0;
      return
    }

    if (element.cantidaPedido > 0) {
      element.cantidaPedido--;
      this.calculateTotal(element);
    }

  }

  calculateTotal(element: any) {

    if (element.cantidaPedido === undefined) {
      element.cantidaPedido = 0;
      element.total = 0;
      return;
    }

    var cantidadGrupo = this.productos
      .filter(p => p.categoriaId === element.categoriaId)
      .reduce((t, pp) => t + (pp.cantidaPedido || 0), 0);

      //ACTUALIZA SOLO EL ELEMENTO

      // if (element.listaPrecios.filter((lp: ProductoListaPrecio) => lp.cantidad <= cantidadGrupo).length > 0) {
      //   const precioGrupo = element.listaPrecios
      //     .filter((lp: ProductoListaPrecio) => lp.cantidad <= cantidadGrupo)
      //     .pop();

      //   if (precioGrupo) {
      //     element.precio = precioGrupo.precio;
      //   }

      // }

      // element.total = element.cantidaPedido * element.precio;


      //ACTUALIZAR EN LOTE FILTRANDO POR GRUPO

      if (element.listaPrecios.filter((lp: ProductoListaPrecio) => lp.cantidad <= cantidadGrupo).length > 0) {

        this.productos
          .filter((prod: Producto) => prod.categoriaId === element.categoriaId)
          .forEach((prod: Producto) => {
            if (!prod.listaPrecios || prod.listaPrecios.length === 0) return;


            const precioGrupo = prod.listaPrecios
              .filter((lp: ProductoListaPrecio) => lp.cantidad <= cantidadGrupo && lp.productoId === prod.id)
              .pop();

            if (precioGrupo) {
              prod.precio = precioGrupo.precio;
            }

            prod.total = (prod.cantidaPedido || 0) * (prod.precio || 0);

          });

      }else {
        element.total = element.cantidaPedido * (element.precio || 0);
      }

  }

}
