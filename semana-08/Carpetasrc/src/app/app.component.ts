import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { PersonaComponent } from './persona/persona.component'; // ✅ Importamos el componente standalone

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
  standalone: true, // ✅ Esto permite que el componente sea independiente
  imports: [CommonModule, IonicModule, PersonaComponent], // ✅ Importamos los módulos necesarios
})
export class AppComponent {
  constructor() {}
}