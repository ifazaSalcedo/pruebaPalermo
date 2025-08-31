import { ProductoPrecios } from "./producto_precios.model";

export interface ProductoModel {
  codigo : number;
  codigoBarra: string;
  descripcion: string;
  precioCompra: number;
  categoriaId: number;
  categoriaDes: string;
  listaPrecios?: ProductoPrecios[];
}
