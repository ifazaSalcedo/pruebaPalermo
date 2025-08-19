import { ProductoListaPrecio } from "./producto-lista-precio-model";

export interface Producto {
  id: string;
  nombre: string;
  precio: number;
  total: number;
  minimo: number;
  categoriaId: number;
  categoria: string;
  categoriaMinimo: number;
  /*Estos campos compete solo al detalle del pedido para el cast*/
  cantidaPedido?: number;
  /*Lista de precios*/
  listaPrecios?: ProductoListaPrecio[];

}


// export const PRODUCTOS_DATA: Producto[] = [
//   { id: 1, nombre: 'Yerba Mate Tradicional', precio: 25000, total: 100, minimo: 20, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0 },
//   { id: 2, nombre: 'Yerba Mate Premium', precio: 32000, total: 80, minimo: 15, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10 , cantidaPedido:0 },
//   { id: 3, nombre: 'Cigarrillos Box 20', precio: 20000, total: 200, minimo: 50, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0  },
//   { id: 4, nombre: 'Cigarrillos Soft 10', precio: 12000, total: 150, minimo: 40, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0  },
//   { id: 5, nombre: 'Balanceado Bovino 25kg', precio: 95000, total: 60, minimo: 10, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0  },
//   { id: 6, nombre: 'Balanceado Porcino 25kg', precio: 88000, total: 50, minimo: 10, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0  },
//   { id: 7, nombre: 'Yerba Mate Suave', precio: 27000, total: 90, minimo: 20, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0  },
//   { id: 8, nombre: 'Cigarrillos Mentolados', precio: 22000, total: 100, minimo: 30, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0  },
//   { id: 9, nombre: 'Balanceado Avícola 40kg', precio: 120000, total: 40, minimo: 8, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0  },
//   { id: 10, nombre: 'Yerba Mate Orgánica', precio: 35000, total: 70, minimo: 15, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0 },
// ];


export const PRODUCTOS_DATA: Producto[] = [
  {
    id: "1", nombre: 'Yerba Mate Tradicional', precio: 25000, total: 100, minimo: 20, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0,
    listaPrecios: [
      { id: 1, productoId: '1', cantidad: 1, precio: 25000, activo: 1 },
      { id: 2, productoId: '1', cantidad: 5, precio: 24000, activo: 1 },
    ]
  },
  {
    id: "2", nombre: 'Yerba Mate Premium', precio: 32000, total: 80, minimo: 15, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0,
    listaPrecios: [
      { id: 3, productoId: '2', cantidad: 1, precio: 32000, activo: 1 },
      { id: 4, productoId: '2', cantidad: 5, precio: 31000, activo: 1 },
    ]
  },
  {
    id: "3", nombre: 'Cigarrillos Box 20', precio: 20000, total: 200, minimo: 50, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0,
    listaPrecios: [
      { id: 5, productoId: '3', cantidad: 1, precio: 20000, activo: 1 },
      { id: 6, productoId: '3', cantidad: 10, precio: 19500, activo: 1 },
    ]
  },
  {
    id: "4", nombre: 'Cigarrillos Soft 10', precio: 12000, total: 150, minimo: 40, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0,
    listaPrecios: [
      { id: 7, productoId: '4', cantidad: 1, precio: 12000, activo: 1 },
      { id: 8, productoId: '4', cantidad: 10, precio: 11500, activo: 1 },
    ]
  },
  {
    id: "5", nombre: 'Balanceado Bovino 25kg', precio: 95000, total: 60, minimo: 10, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0,
    listaPrecios: [
      { id: 9, productoId: '5', cantidad: 1, precio: 95000, activo: 1 },
      { id: 10, productoId: '5', cantidad: 5, precio: 92000, activo: 1 },
    ]
  },
  {
    id: "6", nombre: 'Balanceado Porcino 25kg', precio: 88000, total: 50, minimo: 10, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0,
    listaPrecios: [
      { id: 11, productoId: '6', cantidad: 1, precio: 88000, activo: 1 },
      { id: 12, productoId: '6', cantidad: 5, precio: 86000, activo: 1 },
    ]
  },
  {
    id: "7", nombre: 'Yerba Mate Suave', precio: 27000, total: 90, minimo: 20, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0,
    listaPrecios: [
      { id: 13, productoId: '7', cantidad: 1, precio: 27000, activo: 1 },
      { id: 14, productoId: '7', cantidad: 5, precio: 26000, activo: 1 },
    ]
  },
  {
    id: "8", nombre: 'Cigarrillos Mentolados', precio: 22000, total: 100, minimo: 30, categoriaId: 2, categoria: 'Cigarrillos', categoriaMinimo: 30, cantidaPedido:0,
    listaPrecios: [
      { id: 15, productoId: '8', cantidad: 1, precio: 22000, activo: 1 },
      { id: 16, productoId: '8', cantidad: 10, precio: 21500, activo: 1 },
    ]
  },
  {
    id: "9", nombre: 'Balanceado Avícola 40kg', precio: 120000, total: 40, minimo: 8, categoriaId: 3, categoria: 'Balanceados', categoriaMinimo: 5, cantidaPedido:0,
    listaPrecios: [
      { id: 17, productoId: '9', cantidad: 1, precio: 120000, activo: 1 },
      { id: 18, productoId: '9', cantidad: 5, precio: 118000, activo: 1 },
    ]
  },
  {
    id: "10", nombre: 'Yerba Mate Orgánica', precio: 35000, total: 70, minimo: 15, categoriaId: 1, categoria: 'Yerba', categoriaMinimo: 10, cantidaPedido:0,
    listaPrecios: [
      { id: 19, productoId: '10', cantidad: 1, precio: 35000, activo: 1 },
      { id: 20, productoId: '10', cantidad: 5, precio: 34000, activo: 1 },
    ]
  },
];
