import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './home.page';
import { PersonaComponent } from '../components/persona/persona.component';

const routes: Routes = [
  {
    path: '',
    component: HomePage,
  },
  {
    path: 'persona',
    component: PersonaComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomePageRoutingModule {}
