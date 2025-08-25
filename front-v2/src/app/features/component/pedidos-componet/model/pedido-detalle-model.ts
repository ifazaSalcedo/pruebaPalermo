import { Producto } from "./producto-model";

export interface PedidoDetalle {
  item: number;
  productoId: string;
  producto: Producto;
  cantidad: number;
  precioUnitario: number;
  total: number;
}
