import { Component, OnInit, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { 
  IonItem,
  IonContent,
  IonInput,
  IonButton,
  IonLabel,
  IonIcon
} from '@ionic/angular/standalone';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from '../login/login.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  imports: [
    IonContent,
    IonIcon,
    FormsModule,
    HttpClientModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LoginComponent implements OnInit {
  usuario = {
    email: '',
    contrasenia: ''
  };

  mostrarContrasenia: boolean = false;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {}

  iniciarSesion(form: NgForm): void {
  this.authService.login(this.usuario.email, this.usuario.contrasenia).subscribe({
    next: (res) => {
      localStorage.setItem('usuario', JSON.stringify(res));
      form.resetForm();
      this.router.navigate(['/home']);
    },
    error: (err) => {
      alert('Correo o contraseña incorrectos');
    }
  });
}

  toggleMostrarContrasenia(): void {
    this.mostrarContrasenia = !this.mostrarContrasenia;
  }

  irARegistro(): void {
    this.router.navigate(['/register']);
  }
}