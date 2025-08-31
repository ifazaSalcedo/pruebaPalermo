import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { PedidoService } from '../service/pedido.service';
import { ProductoListaPrecio } from '../model/producto-lista-precio-model';
import { ProductoPedidoModel } from '../model/producto-pedido.model';
import { ProductoPrecios } from '../../producto/model/producto_precios.model';
import { PedidoDetallePedido } from '../model/pedido-detalle-pedido.model';
import { ProductoApiService } from '../../producto/service/producto.api.service';
import { PageBasicResponse } from '../../../../core/model/page-response-basic.model';
import { ProductoModel } from '../../producto/model/producto.model';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-addproducto',
  standalone: true,
  imports: [FormsModule,
    MatTableModule,
    MatButtonModule,
    MatDividerModule,
    CommonModule,
    // CurrencyPipe,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule],
  templateUrl: './addproducto.component.html',
  styleUrl: './addproducto.component.css'
})
export class AddproductoComponent implements OnInit{

  displayedColumns: string[] = ['position', 'symbol'];

  //productos = [] as  ProductoPedidoModel[];

  // productos: ProductoPedidoModel[] = [];

productos = new MatTableDataSource<ProductoPedidoModel>();

//   productos: ProductoPedidoModel[] = [
//   new ProductoPedidoModel({
//     codigo: 1,
//     codigoBarra: '123456',
//     descripcion: 'Producto de prueba',
//     precioCompra: 5000,
//     categoriaId: 10,
//     categoriaDes: 'Categoría A',
//     listaPrecios: [],
//     cantidadPedido: 0,
//     precioUnitario: 0
//   }),
//   new ProductoPedidoModel({
//     codigo: 2,
//     codigoBarra: '789012',
//     descripcion: 'Otro producto',
//     precioCompra: 8000,
//     categoriaId: 10,
//     categoriaDes: 'Categoría A',
//     listaPrecios: [],
//     cantidadPedido: 0,
//     precioUnitario: 0
//   })
// ];

  clickedRows = new Set<PeriodicElement>();

  @Output() retrunPedido= new EventEmitter<void>();

  constructor(private pedidoService: PedidoService, private productoService: ProductoApiService){

  }
  ngOnInit(): void {
    this.getListaProductosDb();
  }

  onReturnPedido(){
    this.retrunPedido.emit();
  }

  onGrabar(){

    this.pedidoService.removeAllProducto();

    this.productos.data
      .filter((prod: ProductoPedidoModel) => (prod.cantidadPedido ?? 0) > 0)
      .forEach((prod: ProductoPedidoModel) => {
        const detalle: PedidoDetallePedido  = {
          item: 1,
          idProducto: prod.codigo,
          desProducto: prod.descripcion,
          cantidad: prod.cantidadPedido!,
          precioUnitario: prod.precioUnitario,
          subTotal: prod.total
        };
        this.pedidoService.addProducto(detalle);
      })

      this.onReturnPedido();

  }

  onAumentarCantidadEvent(element: any) {
    if (element.cantidadPedido === undefined) {
      element.cantidadPedido = 0;
      return
    }
    element.cantidadPedido++;

    //this.calculateTotal(element);
  }

  onDisminuirCantidadEvent(element: any) {
    if (element.cantidadPedido === undefined) {
      element.cantidadPedido = 0;
      return
    }

    if (element.cantidadPedido > 0) {
      element.cantidadPedido--;
      //this.calculateTotal(element);
    }

  }

  calculateTotal(element: any) {

    if (element.cantidadPedido === undefined) {
      element.cantidadPedido = 0;
      element.total = 0;
      return;
    }

    var cantidadGrupo = this.productos
      // .filter(p => p.categoriaId === element.categoriaId)
      // .reduce((t, pp) => t + (pp.cantidadPedido || 0), 0);

      // //ACTUALIZAR EN LOTE FILTRANDO POR GRUPO

      // if (element.listaPrecios.filter((lp: ProductoListaPrecio) => lp.cantidad <= cantidadGrupo).length > 0) {

      //   this.productos
      //     .filter((prod: ProductoPedidoModel) => prod.categoriaId === element.categoriaId)
      //     .forEach((prod: ProductoPedidoModel) => {
      //       if (!prod.listaPrecios || prod.listaPrecios.length === 0) return;

      //       const precioGrupo = prod.listaPrecios
      //         .filter((lp: ProductoPrecios) => lp.cantidad <= cantidadGrupo)
      //         .pop();

      //       if (precioGrupo) {
      //         prod.precioUnitario = precioGrupo.precio;
      //       }

      //       //prod.total = (prod.cantidaPedido || 0) * (prod.precio || 0);

      //     });

      // }else {
      //   //element.total = element.cantidaPedido * (element.precio || 0);
      // }

  }

  getListaProductosDb(){
      this.productoService.getListProductosListaPrecios()
      .subscribe({
        next: (data) => {
          var page: PageBasicResponse<ProductoModel> = data;
          const productosMapeados = page.content.map(p => new ProductoPedidoModel({...p, cantidadPedido: 0, precioUnitario: p.listaPrecios?.[0]?.precio ?? 0}));
          this.productos.data   = productosMapeados;
          console.info(this.productos)
        }
      })
  }

}
