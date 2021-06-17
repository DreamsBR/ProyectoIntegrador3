import { Empleado } from './../../modelos/empleado';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpleadoService } from '../../servicios/empleado.service';
import { Cargo } from '../../modelos/cargo';
import { CargoService } from '../../servicios/cargo.service';
//import { Empleado } from '../../modelos/empleado';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {
  Dcargo :Cargo=new Cargo();
  cargo:Cargo[]=[];
  cargoselect:number=0;
  Dempleado: Empleado =new Empleado();
  empleado: Empleado[]=[];
  constructor(
    private router:Router,
    private servicio:EmpleadoService,
    private serviciocargo: CargoService) { }

  ngOnInit(): void {
    this.listarEmpleado();
    this.listarCargos();

  }

  listarCargos(){
    this.serviciocargo.listar()
            .subscribe(data => {
              this.cargo=data
      });

  }

  listarEmpleado(){
    this.servicio.listar()
    .subscribe(data=> {
      this.empleado=data;
      console.log(this.empleado);
    })
  }

  registrar(empleado:Empleado) {
    this.Dempleado.cargo.id_cargo = this.cargoselect;
    localStorage.setItem("nom_emp", empleado.nom_emp.toString());
    localStorage.setItem("apell_emp", empleado.apell_emp.toString());
    localStorage.setItem("dni_emp", empleado.dni_emp.toString());
    localStorage.setItem("fech_emp", empleado.fech_emp.toString());
    localStorage.setItem("direc_emp", empleado.direc_emp.toString());
    localStorage.setItem("email_emp", empleado.email_emp.toString());
    localStorage.setItem("id_cargo", empleado.cargo.id_cargo.toString());
    localStorage.setItem("telef_emp", empleado.telef_emp.toString());
    localStorage.setItem("estado_emp", empleado.estado_emp.toString());
    let nombre = localStorage.getItem("nom_emp");
    let apell = localStorage.getItem("apell_emp");
    let dni = localStorage.getItem("dni_emp");
    let fecha = localStorage.getItem("fech_emp");
    let direcc = localStorage.getItem("direc_emp");
    let email = localStorage.getItem("email_emp");
    let telf = localStorage.getItem("telef_emp");
    let idcargo = localStorage.getItem("id_cargo");
    let estado = localStorage.getItem("estado_emp");

    if(nombre == "" || apell == "" || dni == "" || fecha == "" || direcc == "" || email == "" || telf == "" || idcargo == "" || estado == ""  ){
      alert("Porfavor complete todos los campos")
    }else{
      this.servicio.registrar(this.Dempleado)
      .subscribe(data => {
        alert("El Empleado se registró Éxitosamente")
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.router.navigate([currentUrl]);
        });
      })
    }}

    Editar(empleado: Empleado) {
      localStorage.setItem("id_emp", empleado.id_emp.toString());
      this.Dempleado.id_emp=this.cargoselect;
      let codigo = localStorage.getItem("id_emp")||0;

      this.servicio.listarId(+codigo)
        .subscribe(data => {
          this.Dempleado = data;
        })
    }
    GuardarEdit(empleado: Empleado) {
    localStorage.setItem("id_emp", empleado.id_emp.toString());
    localStorage.setItem("nom_emp", empleado.nom_emp.toString());
    localStorage.setItem("apell_emp", empleado.apell_emp.toString());
    localStorage.setItem("dni_emp", empleado.dni_emp.toString());
    localStorage.setItem("fech_emp", empleado.fech_emp.toString());
    localStorage.setItem("direc_emp", empleado.direc_emp.toString());
    localStorage.setItem("email_emp", empleado.email_emp.toString());
    localStorage.setItem("telef_emp", empleado.telef_emp.toString());
    localStorage.setItem("id_cargo", empleado.cargo.id_cargo.toString());
    localStorage.setItem("estado_emp", empleado.estado_emp.toString());
    let codigo = localStorage.getItem("id_emp");
    let nombre = localStorage.getItem("nom_emp");
    let apell = localStorage.getItem("apell_emp");
    let dni = localStorage.getItem("dni_emp");
    let fecha = localStorage.getItem("fech_emp");
    let direcc = localStorage.getItem("direc_emp");
    let email = localStorage.getItem("email_emp");
    let telf = localStorage.getItem("telef_emp");
    let idcargo = localStorage.getItem("id_cargo");
    let estado = localStorage.getItem("estado_emp");
      if(codigo == "0"){
        alert("Seleccione en la lista el dato a editar")
      }else if(nombre == "" || apell == "" || dni == "" || fecha == "" || direcc == "" || email == "" || telf == "" || idcargo == "" || estado == "" ){
        alert("Ingrese datos en los campos")
      }else{
        this.servicio.GuardarEdit(empleado)
        .subscribe(data => {
          this.Dempleado = data;
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
