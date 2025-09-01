import { PedidoDetalle } from "./pedido-detalle-model";

export class PedidoDetallePedido implements PedidoDetalle{

  item!: number;
  idProducto!: number;
  desProducto!: string;
  desCategoria!: string;
  cantidad!: number;
  precioUnitario!: number;
  subTotal!: number;

}
