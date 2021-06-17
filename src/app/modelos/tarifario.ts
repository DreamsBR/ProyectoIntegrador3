export class Tarifario {
    id_tarifario:number;
    origen:string;
    destino:string;
    monto:number;

    constructor(id_tarifario:number=0,origen:string="",destino:string="",
    monto:number=0){
      this.id_tarifario=id_tarifario;
      this.origen=origen;
      this.destino=destino;
      this.monto=monto;
    }
}
