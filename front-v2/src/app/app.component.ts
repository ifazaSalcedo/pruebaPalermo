import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PedidosComponent } from "./shared/component/pedidos-componet/pedidos/pedidos.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-v2';
}
