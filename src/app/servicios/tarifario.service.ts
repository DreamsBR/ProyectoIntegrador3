import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tarifario } from '../modelos/tarifario';

@Injectable({
  providedIn: 'root'
})
export class TarifarioService {
  url:string="http://localhost:8087/maven/tarifario"
  constructor(private Http:HttpClient) { }
  listar(){
    return this.Http.get<Tarifario[]>(this.url)
  }
   registrar(tarifario:Tarifario){
    return this.Http.post<Tarifario>(this.url, tarifario)
  }
  listarId(id_tarifario:number){
    return this.Http.get<Tarifario>(this.url+"/"+id_tarifario);
  }
  GuardarEdit(tarifario:Tarifario){
    return this.Http.put<Tarifario>(this.url ,tarifario)
  }
}
