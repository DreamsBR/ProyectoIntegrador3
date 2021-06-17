import { Empleado } from './../modelos/empleado';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  url:string="http://localhost:8087/maven/rest/empleado"
  constructor(private Http:HttpClient) { }

  listar(){
    return this.Http.get<Empleado[]>(this.url);
  }
  registrar(empleado:Empleado){
    return this.Http.post<Empleado>(this.url, empleado)
  }
  listarId(id_emp:number){
    return this.Http.get<Empleado>(this.url+"/"+id_emp);
  }
  GuardarEdit(empleado:Empleado){
    return this.Http.put<Empleado>(this.url ,empleado)
  }
}
