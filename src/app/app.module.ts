import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { EmpleadoComponent } from './componentes/empleado/empleado.component';
import { CargoComponent } from './componentes/cargo/cargo.component';
import { ChoferComponent } from './componentes/chofer/chofer.component';
import { VehiculoComponent } from './componentes/vehiculo/vehiculo.component';
import { TarifarioComponent } from './componentes/tarifario/tarifario.component';
import { CargoService } from './servicios/cargo.service';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    EmpleadoComponent,
    CargoComponent,
    ChoferComponent,
    VehiculoComponent,
    TarifarioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    CargoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
