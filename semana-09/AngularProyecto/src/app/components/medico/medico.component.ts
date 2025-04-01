import { Component } from '@angular/core';
import { PersonaComponent } from '../persona/persona.component';
import { IonToolbar, IonHeader, IonTitle, IonContent, IonItem, IonLabel, IonInput, IonButton } from "@ionic/angular/standalone";

@Component({
  selector: 'app-medico',
  standalone: true,
  imports: [IonButton, IonInput, IonLabel, IonItem, IonContent, IonTitle, IonHeader, IonToolbar, PersonaComponent],
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent {
 
}
