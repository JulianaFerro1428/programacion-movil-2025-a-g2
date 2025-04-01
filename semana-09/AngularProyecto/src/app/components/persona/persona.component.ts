import { Component, Input } from '@angular/core';

export interface Persona {
  tipo: string;
  nombre: string;
  apellido: string;
  edad: number;
  email: string;
}

@Component({
  selector: 'app-persona',
  standalone: true,
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.scss']
})
export class PersonaComponent {
  @Input() tipo: string = ''; // Tipo de persona
  @Input() persona: Persona = { tipo: '', nombre: '', apellido: '', edad: 0, email: '' }; // Datos de la persona
}
