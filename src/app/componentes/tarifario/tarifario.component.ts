import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tarifario } from '../../modelos/tarifario';
import { TarifarioService } from '../../servicios/tarifario.service';

@Component({
  selector: 'app-tarifario',
  templateUrl: './tarifario.component.html',
  styleUrls: ['./tarifario.component.css']
})
export class TarifarioComponent implements OnInit {

  Dtarifario: Tarifario=new Tarifario();
  tarifario: Tarifario[]=[]
  constructor(private router:Router,private servicio:TarifarioService) { }

  ngOnInit(): void {
    this.servicio.listar()
    .subscribe(data =>{
      this.tarifario=data;
    })
  }
  registrar(tarifario:Tarifario) {
    localStorage.setItem("origen", tarifario.origen.toString());
    localStorage.setItem("destino", tarifario.destino.toString());
    localStorage.setItem("monto", tarifario.monto.toString());
    let origen = localStorage.getItem("origen");
    let destino = localStorage.getItem("destino");
    let monto = localStorage.getItem("monto");
    if(origen == "" || destino == "" || monto == "" ){
      alert("Porfavor complete todos los campos")
    }else{
      this.servicio.registrar(this.Dtarifario)
      .subscribe(data => {
        alert("El Tarifario se registró Éxitosamente")
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }
  }

  Editar(tarifario: Tarifario) {
    localStorage.setItem("id_tarifario", tarifario.id_tarifario.toString());
    let codigo = localStorage.getItem("id_tarifario")||0;
    this.servicio.listarId(+codigo)
      .subscribe(data => {
        this.Dtarifario = data;
      })
  }
  
  GuardarEdit(tarifario: Tarifario) {
    localStorage.setItem("id_tarifario", tarifario.id_tarifario.toString());
    localStorage.setItem("origen", tarifario.origen.toString());
    localStorage.setItem("destino", tarifario.destino.toString());
    localStorage.setItem("monto", tarifario.monto.toString());
    let codigo = localStorage.getItem("id_tarifario");
    let origen = localStorage.getItem("nomb_car");
    let destino = localStorage.getItem("sueldo_car");
    let monto = localStorage.getItem("descrip_car");
    if(codigo == "0"){
      alert("Seleccione en la lista el dato a editar")
    }else if(origen == "" || destino == "" || monto == "" ){
      alert("Ingrese datos en los campos")
    }else{
      this.servicio.GuardarEdit(tarifario)
      .subscribe(data => {
        this.Dtarifario = data;
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
