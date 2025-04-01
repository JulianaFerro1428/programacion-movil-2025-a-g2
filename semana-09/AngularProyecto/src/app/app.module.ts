import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PersonaComponent } from './components/persona/persona.component';
import { RecepcionistaComponent } from './components/recepcionista/recepcionista.component';
import { MedicoComponent } from './components/medico/medico.component';
import { FormsModule } from '@angular/forms';
import { PacienteComponent } from './components/paciente/paciente.component';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, FormsModule, PacienteComponent, RecepcionistaComponent, MedicoComponent],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
