import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { PedidoDetalle } from '../../../model/pedido-detalle-model';
import { MatCardModule } from "@angular/material/card";
import { PedidoService } from '../service/pedido.service';
import { MatSelectModule } from "@angular/material/select";
import { MatIconModule } from "@angular/material/icon";
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { CommonModule, CurrencyPipe, registerLocaleData } from '@angular/common';
import localeEsPy from '@angular/common/locales/es-PY';
registerLocaleData(localeEsPy);

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

@Component({
  selector: 'app-pedidosdet',
  standalone: true,
  imports: [FormsModule,MatTableModule,CurrencyPipe,
    MatCardModule, MatSelectModule, CommonModule,
    MatIconModule, MatFormFieldModule, MatInputModule],
  templateUrl: './pedidosdet.component.html',
  styleUrl: './pedidosdet.component.css'
})
export class PedidosdetComponent {



  displayedColumns: string[] = ['position', 'symbol'];
  dataSource = ELEMENT_DATA;
  clickedRows = new Set<PeriodicElement>();

  pedidoDetalle: PedidoDetalle[] = [];

  constructor(private pedidoService: PedidoService) {

    this.pedidoService.pedidoDetalle$.subscribe(detalle => {
      this.pedidoDetalle = detalle;
    });


  }



}
