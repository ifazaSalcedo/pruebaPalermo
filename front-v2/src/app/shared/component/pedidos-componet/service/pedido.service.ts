import { BehaviorSubject } from "rxjs";
import { PedidoDetalle } from "../../../model/pedido-detalle-model";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class PedidoService {

  private pedidoDetalleSource = new BehaviorSubject<PedidoDetalle[]>([]);
  pedidoDetalle$ = this.pedidoDetalleSource.asObservable();


  constructor() { }

  getPedidoDetalle(): PedidoDetalle[] {
    return this.pedidoDetalleSource.value;
  }

  setPedidoDetalle(detalle: PedidoDetalle[]): void {
    this.pedidoDetalleSource.next(detalle);
  }

  addProducto(producto: PedidoDetalle): void {
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
