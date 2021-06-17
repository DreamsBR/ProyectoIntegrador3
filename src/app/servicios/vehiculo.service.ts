import { Vehiculo } from './../modelos/vehiculo';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {
  url:string="http://localhost:8087/maven/vehiculo"
  constructor(private Http:HttpClient) { }
  listar(){
    return this.Http.get<Vehiculo[]>(this.url)
  }
   registrar(vehiculo:Vehiculo){
    return this.Http.post<Vehiculo>(this.url, vehiculo)
  }
  listarId(id_vehiculo:number){
    return this.Http.get<Vehiculo>(this.url+"/"+id_vehiculo);
  }
  GuardarEdit(vehiculo:Vehiculo){
    return this.Http.put<Vehiculo>(this.url ,vehiculo)
  }
}
