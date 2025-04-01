import { Component, OnInit } from '@angular/core';
import { PersonaComponent } from '../persona/persona.component';
import { IonToolbar, IonTitle, IonContent, IonLabel, IonItem, IonInput, IonButton, IonHeader } from "@ionic/angular/standalone";

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss'],
  imports: [IonHeader, IonButton, IonInput, IonItem, IonLabel, IonContent, IonTitle, IonToolbar, PersonaComponent],
})
export class PacienteComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
