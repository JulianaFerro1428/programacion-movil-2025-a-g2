import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { HomePage } from './home.page';


import { ClienteComponent } from "../components/cliente/cliente.component";
import { FechaComponent } from "../components/fecha/fecha.component";
import { MesaComponent } from "../components/mesa/mesa.component";



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ClienteComponent,
    FechaComponent,
    MesaComponent
],
  declarations: [],
})
export class HomePageModule {}
