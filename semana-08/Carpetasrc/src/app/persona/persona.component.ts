import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { Persona } from '../persona/persona';

@Component({
  selector: 'app-persona',
  standalone: true,
  imports: [CommonModule, IonicModule],
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.scss']
})
export class PersonaComponent {
  @Input() persona!: Persona; 
  @Input() tipoUsuario!: 'cliente' | 'proveedor'; 
}
