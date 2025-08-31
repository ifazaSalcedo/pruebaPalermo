import { ProductoModel } from "../../producto/model/producto.model";
import { ProductoPrecios } from "../../producto/model/producto_precios.model";

export class ProductoPedidoModel implements ProductoModel {
  codigo!: number ;
  codigoBarra!: string;
  descripcion!: string;
  precioCompra!: number;
  categoriaId!: number;
  categoriaDes!: string;
  listaPrecios?: ProductoPrecios[];
  cantidadPedido: number = 0;
  precioUnitario: number = 0;


  constructor(init?: Partial<ProductoModel & { cantidadPedido: number; precioUnitario: number }>) {
    Object.assign(this, init);
  }

  get total() : number{
    return this.cantidadPedido * this.precioUnitario;
  }

}
