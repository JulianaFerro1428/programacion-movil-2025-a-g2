import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  
  {
    path: '',
    redirectTo: 'home',  
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadComponent: () => import('./home/home.page').then(m => m.HomePage)
  },
  {
    path: 'cliente',
    loadComponent: () => import('./components/cliente/cliente.component').then(m => m.ClienteComponent)
  },
  {
    path: 'mesa',
    loadComponent: () => import('./components/mesa/mesa.component').then(m => m.MesaComponent)
  },
  {
    path: 'fecha',
    loadComponent: () => import('./components/fecha/fecha.component').then(m => m.FechaComponent)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
