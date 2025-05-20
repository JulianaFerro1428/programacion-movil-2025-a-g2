import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from './usuario';
import { RegisterService } from './register.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    IonicModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {

  registerForm!: FormGroup;
  showPassword = false;

  nuevoUsuario: Usuario = {
    nombres: '',
    apellidos: '',
    phone: '',
    email: '',
    contrasenia: ''
  };

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private serviciosUsuario: RegisterService
  ) {}

  ngOnInit() {
    this.registerForm = this.fb.group({
      nombres: ['', [Validators.required]],
      apellidos: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]*$')]], // Solo números
      email: ['', [Validators.required, Validators.email]], // Formato de email
      contrasenia: ['', [Validators.required, Validators.minLength(6)]] // Mínimo 6 caracteres
    });
  }

  registrarUsuario(): void {
    if (this.registerForm.valid) {
      this.serviciosUsuario.create(this.registerForm.value).subscribe({
        next: (result) => {
          console.log('Registro exitoso', result);
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error('Error en registro', error);
        }
      });
    }
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }

  irAlogin(): void {
    this.router.navigate(['/login']);
  }
}