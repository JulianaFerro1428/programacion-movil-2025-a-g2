import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { Tarea } from './tarea';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { TareasService } from './tareas.service';
import { HttpErrorResponse } from '@angular/common/http';  // Importar para los errores HTTP
import { HttpClientModule } from '@angular/common/http'; // Importar para el cliente HTTP


@Component({
  selector: 'app-tareas',
  standalone: true,
  imports: [IonicModule, CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './tareas.component.html',
  styleUrls: ['./tareas.component.scss'],
})
export class TareasComponent implements OnInit {
  tareaForm!: FormGroup;
  mensajeModal: string | null = null;

  nuevaTarea: Tarea = {
    fullname: '',
    description: '',
    categoria: '',
    fechaCreacion: '',
    isFinished:false
  };

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private tareasService: TareasService
  ) {}

  ngOnInit(): void {
    this.tareaForm = this.fb.group({
      fullname: ['', [Validators.required]],
      description: ['', [Validators.required]],
      categoria: ['', [Validators.required]],
      fechaCreacion: ['', [Validators.required]]
      
    });
  }

 registrarTarea(): void {
  if (this.tareaForm.valid) {
    const usuario = JSON.parse(localStorage.getItem('usuario') || '{}');

    const nuevaTarea = {
      ...this.tareaForm.value,
      isFinished: false,
      usuario: { id: usuario.id }
    };

    this.tareasService.create(nuevaTarea).subscribe({
      next: (result: Tarea) => {
        console.log('Tarea creada exitosamente', result);
        this.mensajeModal = '✅ La tarea fue creada correctamente.';

        // 🔽 Limpia el formulario después de crear la tarea
        this.tareaForm.reset();

        // Opcional: elimina cualquier mensaje de error visual
        this.tareaForm.markAsPristine();
        this.tareaForm.markAsUntouched();

        // Redirige tras unos segundos (puedes ajustar el tiempo)
        setTimeout(() => this.router.navigate(['/home']), 2);
      },
      error: (error: HttpErrorResponse) => {
        console.error('Error al crear la tarea', error);
        this.mensajeModal = `❌ Ocurrió un error: ${error.error?.message || 'Inténtalo nuevamente.'}`;
      }
    });
  }
}


  cerrarModal(): void {
    this.mensajeModal = null;
    this.router.navigate(['/home']);
  }
}
