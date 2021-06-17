import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Chofer } from '../modelos/chofer';

@Injectable({
  providedIn: 'root'
})
export class ChoferService {
  url:string="http://localhost:8087/maven/rest/chofer"
  constructor(private Http:HttpClient) { }
  listar(){
    return this.Http.get<Chofer[]>(this.url)
  }
  registrar(chofer:Chofer){
    return this.Http.post<Chofer>(this.url, chofer)
  }
  listarId(id_chofer:number){
    return this.Http.get<Chofer>(this.url+"/"+id_chofer);
  }
  GuardarEdit(chofer:Chofer){
    return this.Http.put<Chofer>(this.url,chofer)
  }
}
