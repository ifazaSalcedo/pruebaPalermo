import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PedidosComponent } from './features/component/pedidos-componet/pedidos/pedidos.component';
//{ path: '', component: AppComponent },
export const routes: Routes = [

  { path: 'pedidos', component: PedidosComponent },
];
