import { Cargo } from './cargo';

export class Empleado {
    id_emp!:number;
    nom_emp!:string;
    apell_emp!:string;
    dni_emp!:string;
    fech_emp!:string;
    direc_emp!:string;
    email_emp!:string;
    telef_emp!:string;
    estado_emp!:string;
    cargo:Cargo;

    constructor(){
      this.cargo = new Cargo;
    }
}
