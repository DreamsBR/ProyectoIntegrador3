export class Vehiculo {
    id_vehiculo:number;
    tipo:string;
    matricula:string;
    modelo:string;
    marca:string;

    constructor(id_vehiculo:number=0,tipo:string="",matricula:string="",modelo="",
    marca:string=""){
     this.id_vehiculo=id_vehiculo;
     this.tipo=tipo;
     this.matricula=matricula;
     this.modelo=modelo;
     this.marca=marca;
    }
}
