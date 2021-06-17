import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Chofer } from '../../modelos/chofer';
import { ChoferService } from '../../servicios/chofer.service';

@Component({
  selector: 'app-chofer',
  templateUrl: './chofer.component.html',
  styleUrls: ['./chofer.component.css']
})
export class ChoferComponent implements OnInit {

  Dchofer: Chofer=new Chofer();
  chofer: Chofer[]=[]
  constructor(private router:Router,private servicio:ChoferService) { }

  ngOnInit(): void {
    this.servicio.listar()
    .subscribe(data =>{
      this.chofer=data;
    })
  }
 registrar(chofer:Chofer) {
    localStorage.setItem("nomb_chof", chofer.nomb_chof.toString());
    localStorage.setItem("apell_chof", chofer.apell_chof.toString());
    localStorage.setItem("dni_chofer", chofer.dni_chofer.toString());
    localStorage.setItem("sexo_chof", chofer.sexo_chof.toString());
    localStorage.setItem("direc_chof", chofer.direc_chof.toString());
    localStorage.setItem("telef_chof", chofer.telef_chof.toString());
    localStorage.setItem("email_chof", chofer.email_chof.toString());
    localStorage.setItem("n_brevete", chofer.n_brevete.toString());
    localStorage.setItem("id_vehiculo", chofer.id_vehiculo.toString());
    let nombre = localStorage.getItem("nomb_chof");
    let apell = localStorage.getItem("apell_chof");
    let dni = localStorage.getItem("dni_chofer");
    let sexo = localStorage.getItem("sexo_chof");
    let direcc = localStorage.getItem("direc_chof");
    let telf = localStorage.getItem("telef_chof");
    let email = localStorage.getItem("email_chof");
    let n_brevete = localStorage.getItem("n_brevete");
    let id_vehiculo = localStorage.getItem("id_vehiculo");
    if(nombre == "" || apell == "" || dni == "" || sexo == "" || direcc == "" || telf == "" || email == "" || n_brevete == "" || id_vehiculo == "" ){
      alert("Porfavor complete todos los campos")
    }else{
      this.servicio.registrar(this.Dchofer)
      .subscribe(data => {
        alert("El Chofer se registró Éxitosamente")
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }}

    
  Editar(chofer: Chofer) {
    localStorage.setItem("id_chofer", chofer.id_chofer.toString());
    let codigo = localStorage.getItem("id_chofer")||0;
    this.servicio.listarId(+codigo)
      .subscribe(data => {
        this.Dchofer = data;
      })
  }
  GuardarEdit(chofer: Chofer) {
    localStorage.setItem("id_chofer", chofer.id_chofer.toString());
    localStorage.setItem("nomb_chof", chofer.nomb_chof.toString());
    localStorage.setItem("apell_chof", chofer.apell_chof.toString());
    localStorage.setItem("dni_chofer", chofer.dni_chofer.toString());
    localStorage.setItem("sexo_chof", chofer.sexo_chof.toString());
    localStorage.setItem("direc_chof", chofer.direc_chof.toString());
    localStorage.setItem("telef_chof", chofer.telef_chof.toString());
    localStorage.setItem("email_chof", chofer.email_chof.toString());
    localStorage.setItem("n_brevete", chofer.n_brevete.toString());
    localStorage.setItem("id_vehiculo", chofer.id_vehiculo.toString());
    let codigo = localStorage.getItem("id_chofer");
    let nombre = localStorage.getItem("nomb_chof");
    let apell = localStorage.getItem("apell_chof");
    let dni = localStorage.getItem("dni_chofer");
    let sexo = localStorage.getItem("sexo_chof");
    let direcc = localStorage.getItem("direc_chof");
    let telf = localStorage.getItem("telef_chof");
    let email = localStorage.getItem("email_chof");
    let n_brevete = localStorage.getItem("n_brevete");
    let id_vehiculo = localStorage.getItem("id_vehiculo");
    if(codigo == "0"){
      alert("Seleccione en la lista el dato a editar")
    }else if(nombre == ""  || apell == "" || dni == "" || sexo == "" || direcc == "" || telf == "" || email == "" || n_brevete == ""  || id_vehiculo == ""){
      alert("Ingrese datos en los campos")
    }else{
      this.servicio.GuardarEdit(chofer)
      .subscribe(data => {
        this.Dchofer = data;
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
  Sexo:String="Sexo"
}
