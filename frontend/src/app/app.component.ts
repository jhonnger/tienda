import {Component, OnInit} from '@angular/core';
import {ProductoService} from "./producto.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'tienda';

  public productos: Producto[];

  constructor(private servicio: ProductoService) {
    this.productos = [];
  }

  ngOnInit(): void {
    this.servicio.listarProductos()
      .subscribe((data: any) => {
        this.productos = data;
      console.log(data)
    }, error => {
      console.error(error)
    })
  }



}

interface Producto{
  nombre: string;
  precio: number;
  fecha: Date;
}
