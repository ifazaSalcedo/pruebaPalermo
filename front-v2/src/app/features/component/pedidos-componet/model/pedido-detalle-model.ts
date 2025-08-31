import { Producto } from "./producto-model";

export interface PedidoDetalle {
  item: number;
  idProducto: number;
  cantidad: number;
  precioUnitario: number;
  subTotal: number;
}
