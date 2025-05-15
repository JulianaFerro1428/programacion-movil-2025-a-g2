import { Component, OnInit } from '@angular/core';
import { IonInput, IonLabel, IonItem, IonCardContent, IonCardHeader, IonCard, IonCardTitle } from "@ionic/angular/standalone";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cliente',
  imports: [IonCardTitle, IonCard, IonCardHeader, IonCardContent, IonLabel, IonItem, CommonModule, FormsModule, IonInput],
  standalone: true,
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss'],
})
export class ClienteComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
