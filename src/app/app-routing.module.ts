import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CargoComponent } from './componentes/cargo/cargo.component';
import { EmpleadoComponent } from './componentes/empleado/empleado.component';
import { ChoferComponent } from './componentes/chofer/chofer.component';
import { VehiculoComponent } from './componentes/vehiculo/vehiculo.component';
import { TarifarioComponent } from './componentes/tarifario/tarifario.component';
import { MenuComponent } from './componentes/menu/menu.component';

const routes: Routes = [
  {path:"",redirectTo:"RS",pathMatch:"full"},
  {path:"RS",component:MenuComponent},
  {path:"RS/cargo",component:CargoComponent},
  {path:"RS/empleado",component:EmpleadoComponent},
  {path:"RS/chofer",component:ChoferComponent},
  {path:"RS/vehiculo",component:VehiculoComponent},
  {path:"RS/tarifario",component:TarifarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
