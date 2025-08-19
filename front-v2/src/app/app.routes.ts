import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PedidosComponent } from './shared/component/pedidos-componet/pedidos/pedidos.component';
//{ path: '', component: AppComponent },
export const routes: Routes = [

  { path: 'pedidos', component: PedidosComponent },
];
