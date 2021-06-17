import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CargoService } from '../../servicios/cargo.service';
import { Cargo } from '../../modelos/cargo';

@Component({
  selector: 'app-cargo',
  templateUrl: './cargo.component.html',
  styleUrls: ['./cargo.component.css']
})
export class CargoComponent implements OnInit {
   Dcargo: Cargo =new Cargo();
   cargo:  Cargo[]=[]
  constructor(private router:Router,private servicio:CargoService) { }

  ngOnInit(): void {
    this.servicio.listar()
    .subscribe(data =>{
      this.cargo=data;
    })
  }

  registrar(cargo:Cargo) {
    localStorage.setItem("nomb_car", cargo.nomb_car.toString());
    localStorage.setItem("sueldo_car", cargo.sueldo_car.toString());
    localStorage.setItem("descrip_car", cargo.descrip_car.toString());
    let nombre = localStorage.getItem("nomb_car");
    let sueldo = localStorage.getItem("sueldo_car");
    let desc = localStorage.getItem("descrip_car");
    if(nombre == "" || sueldo == "" || desc == "" ){
      alert("Porfavor complete todos los campos")
    }else{
      this.servicio.registrar(this.Dcargo)
      .subscribe(data => {
        alert("El Cargo se registró Éxitosamente")
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }
  }

  Editar(cargo: Cargo) {
    localStorage.setItem("id_cargo", cargo.id_cargo.toString());
    let codigo = localStorage.getItem("id_cargo")||0;
    this.servicio.listarId(+codigo)
      .subscribe(data => {
        this.Dcargo = data;
      })
  }

  GuardarEdit(cargo: Cargo) {
    localStorage.setItem("id_cargo", cargo.id_cargo.toString());
    localStorage.setItem("nomb_car", cargo.nomb_car.toString());
    localStorage.setItem("sueldo_car", cargo.sueldo_car.toString());
    localStorage.setItem("descrip_car", cargo.descrip_car.toString());
    let codigo = localStorage.getItem("id_cargo");
    let nombre = localStorage.getItem("nomb_car");
    let sueldo = localStorage.getItem("sueldo_car");
    let desc = localStorage.getItem("descrip_car");
    if(codigo == "0"){
      alert("Seleccione en la lista el dato a editar")
    }else if(nombre == "" || sueldo == "" || desc == "" ){
      alert("Ingrese datos en los campos")
    }else{
      this.servicio.GuardarEdit(cargo)
      .subscribe(data => {
        this.Dcargo = data;
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
