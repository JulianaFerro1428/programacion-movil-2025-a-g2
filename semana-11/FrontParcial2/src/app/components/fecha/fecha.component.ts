import { Component, OnInit } from '@angular/core';
import { IonDatetime, IonCardContent, IonCard, IonCardHeader, IonCardTitle, IonItem, IonLabel } from "@ionic/angular/standalone";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fecha',
  imports: [IonLabel, IonItem, IonCardTitle, IonCardHeader, IonCard, IonCardContent, CommonModule, FormsModule, IonDatetime],
  standalone: true,
  templateUrl: './fecha.component.html',
  styleUrls: ['./fecha.component.scss'],
})
export class FechaComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
