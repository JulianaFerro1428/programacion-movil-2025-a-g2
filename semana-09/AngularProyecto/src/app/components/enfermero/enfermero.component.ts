import { Component, OnInit } from '@angular/core';
import { PersonaComponent } from '../persona/persona.component';
import { IonHeader, IonTitle, IonContent, IonItem, IonLabel, IonInput, IonButton, IonToolbar } from "@ionic/angular/standalone";

@Component({
  selector: 'app-enfermero',
  templateUrl: './enfermero.component.html',
  styleUrls: ['./enfermero.component.scss'],
  imports: [IonToolbar, IonButton, IonInput, IonLabel, IonItem, IonContent, IonTitle, IonHeader, PersonaComponent],  // Asegúrate de que PersonaComponent esté aquí
})
export class EnfermeroComponent implements OnInit {
  especialidad: string = '';
  licenciaMedica: string = '';

  constructor() {}

  ngOnInit() {}

  guardarEnfermero() {
    // Lógica para guardar el enfermero, si es necesario
    console.log({
      especialidad: this.especialidad,
      licenciaMedica: this.licenciaMedica,
    });
  }
}
