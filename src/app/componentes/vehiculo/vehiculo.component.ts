import { Vehiculo } from './../../modelos/vehiculo';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculoService } from '../../servicios/vehiculo.service';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css']
})
export class VehiculoComponent implements OnInit {

  Dvehiculo: Vehiculo= new Vehiculo();
  vehiculo: Vehiculo[]=[]
  constructor(private router:Router,private servicio:VehiculoService) { }

  ngOnInit(): void {
    this.servicio.listar()
    .subscribe(data =>{
      this.vehiculo=data;
    })
  }
  registrar(vehiculo:Vehiculo) {
    localStorage.setItem("tipo", vehiculo.tipo.toString());
    localStorage.setItem("matricula", vehiculo.matricula.toString());
    localStorage.setItem("modelo", vehiculo.modelo.toString());
    localStorage.setItem("marca", vehiculo.marca.toString());
    let tipo = localStorage.getItem("tipo");
    let matricula = localStorage.getItem("matricula");
    let modelo = localStorage.getItem("modelo");
    let marca = localStorage.getItem("marca");
    if(tipo == "" || matricula == "" || modelo == ""|| marca == "" ){
      alert("Porfavor complete todos los campos")
    }else{
      this.servicio.registrar(this.Dvehiculo)
      .subscribe(data => {
        alert("El Vehiculo se registró Éxitosamente")
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }
  }

  Editar(vehiculo: Vehiculo) {
    localStorage.setItem("id_vehiculo", vehiculo.id_vehiculo.toString());
    let codigo = localStorage.getItem("id_vehiculo")||0;
    this.servicio.listarId(+codigo)
      .subscribe(data => {
        this.Dvehiculo = data;
      })
  }
  GuardarEdit(vehiculo: Vehiculo) {
    localStorage.setItem("id_vehiculo", vehiculo.id_vehiculo.toString());
    localStorage.setItem("tipo", vehiculo.tipo.toString());
    localStorage.setItem("matricula", vehiculo.matricula.toString());
    localStorage.setItem("modelo", vehiculo.modelo.toString());
    localStorage.setItem("marca", vehiculo.marca.toString());
    let codigo = localStorage.getItem("id_tarifario");
    let tipo = localStorage.getItem("tipo");
    let matricula = localStorage.getItem("matricula");
    let modelo = localStorage.getItem("modelo");
    let marca = localStorage.getItem("marca");
    if(codigo == "0"){
      alert("Seleccione en la lista el dato a editar")
    }else if(tipo == "" || matricula == "" || modelo == ""|| marca == ""  ){
      alert("Ingrese datos en los campos")
    }else{
      this.servicio.GuardarEdit(vehiculo)
      .subscribe(data => {
        this.Dvehiculo = data;
        alert("Se actualizó con éxito!!");
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }  
  }
  Cancelar(){
    let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
  }
  Blockbtn:boolean=false;
}
