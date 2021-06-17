import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cargo } from '../modelos/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {
   url:string="http://localhost:8087/maven/rest/cargo"
  constructor(private Http:HttpClient) { }
  listar(){
    return this.Http.get<Cargo[]>(this.url)
  }
   registrar(cargo:Cargo){
    return this.Http.post<Cargo>(this.url, cargo)
  }
  listarId(id_cargo:number){
    return this.Http.get<Cargo>(this.url+"/"+id_cargo);
  }
  GuardarEdit(cargo:Cargo){
    return this.Http.put<Cargo>(this.url ,cargo)
  }
 
}
