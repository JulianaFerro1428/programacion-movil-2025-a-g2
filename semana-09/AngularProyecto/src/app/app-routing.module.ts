import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { MedicoComponent } from './components/medico/medico.component';
import { EnfermeroComponent } from './components/enfermero/enfermero.component';
import { PacienteComponent } from './components/paciente/paciente.component';
import { RecepcionistaComponent } from './components/recepcionista/recepcionista.component';
import { PersonaComponent } from './components/persona/persona.component';

const routes: Routes = [
  {
    path: 'home',  // Si tienes una página home, la puedes dejar o cambiar por 'persona'
    component: PersonaComponent  // O el componente que quieras como home
  },
  {
    path: '',
    redirectTo: 'persona',  // Redirige por defecto al componente 'persona'
    pathMatch: 'full'
  },
  {
    path: 'persona',
    component: PersonaComponent
  },
  {
    path: 'paciente',
    component: PacienteComponent
  },
  {
    path: 'recepcionista',
    component: RecepcionistaComponent
  },
  {
    path: 'medico',
    component: MedicoComponent
  },
  {
    path: 'enfermero',
    component: EnfermeroComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
