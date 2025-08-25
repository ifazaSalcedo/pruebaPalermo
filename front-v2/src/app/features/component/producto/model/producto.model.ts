import { ProductoPrecios } from "./producto_precios.model";

export interface Producto {
  id : number;
  codigoBarra: string;
  descripcion: string;
  precioCompra: number;
  categoriaId: number;
  categoriaDes: string;
  listaPrecios?: ProductoPrecios[];
}
