import { Component, OnInit } from '@angular/core';
import { PersonaComponent } from '../persona/persona.component';
import { IonContent, IonToolbar, IonTitle, IonInput, IonItem, IonLabel, IonButton, IonHeader } from "@ionic/angular/standalone";

@Component({
  selector: 'app-recepcionista',
  templateUrl: './recepcionista.component.html',
  styleUrls: ['./recepcionista.component.scss'],
  imports: [IonHeader, IonButton, IonLabel, IonItem, IonInput, IonTitle, IonToolbar, IonContent, PersonaComponent],
})
export class RecepcionistaComponent implements OnInit {

  constructor() { }

  ngOnInit() {}

}
