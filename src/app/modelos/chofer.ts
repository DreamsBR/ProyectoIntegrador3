import { Vehiculo } from './vehiculo';
export class Chofer {
    id_chofer:number;
    nomb_chof:string;
    apell_chof:string;
    dni_chofer:string;
    sexo_chof:string;
    direc_chof:string;
    telef_chof:string;
    email_chof:string;
    n_brevete:string;
    id_vehiculo:number;

    constructor(id_chofer:number=0,nomb_chof:string="",apell_chof:string="",
    dni_chofer:string="",sexo_chof:string="",direc_chof:string="",telef_chof:string="",
    email_chof:string="",n_brevete:string="",id_vehiculo:number=0){
        this.id_chofer=id_chofer;
        this.nomb_chof=nomb_chof;
        this.apell_chof=apell_chof;
        this.dni_chofer=dni_chofer;
        this.sexo_chof=sexo_chof;
        this.direc_chof=direc_chof;
        this.telef_chof=telef_chof;
        this.email_chof=email_chof;
        this.n_brevete=n_brevete;
        this.id_vehiculo=id_vehiculo;
    }
}
