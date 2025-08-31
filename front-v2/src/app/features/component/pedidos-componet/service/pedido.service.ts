import { BehaviorSubject } from "rxjs";
import { Injectable } from "@angular/core";
import { PedidoDetalle } from "../model/pedido-detalle-model";
import { PedidoDetallePedido } from "../model/pedido-detalle-pedido.model";

@Injectable({
  providedIn: 'root'
})

export class PedidoService {

  private pedidoDetalleSource = new BehaviorSubject<PedidoDetallePedido[]>([]);

  pedidoDetalle$ = this.pedidoDetalleSource.asObservable();


  constructor() { }

  getPedidoDetalle(): PedidoDetallePedido[] {
    return this.pedidoDetalleSource.value;
  }

  setPedidoDetalle(detalle: PedidoDetallePedido[]): void {
    this.pedidoDetalleSource.next(detalle);
  }

  addProducto(producto: PedidoDetallePedido): void {
    if (producto.cantidad && producto.cantidad > 0) {
      const pedidos = [...this.pedidoDetalleSource.value, producto];
      this.pedidoDetalleSource.next(pedidos);
    }
  }

  removeAllProducto(){
    this.pedidoDetalleSource.next([]);
  }

  getSize(): number {
    return this.pedidoDetalleSource.value.length;
  }

  // removeProducto(id: number): void {
  //   const pedidos = this.pedidoDetalleSource.value.filter(p => p.id !== id);
  //   this.pedidoDetalleSource.next(pedidos);
  // }

}
