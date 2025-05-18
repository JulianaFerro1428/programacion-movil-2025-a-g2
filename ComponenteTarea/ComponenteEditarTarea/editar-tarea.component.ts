import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TareasService } from '../../tareas.service';
import { Tarea } from '../../tarea';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-editar-tarea',
  imports:[
    IonicModule, CommonModule, ReactiveFormsModule
  ],
  templateUrl: './editar-tarea.component.html',
  styleUrls: ['./editar-tarea.component.scss'],
})
export class EditarTareaComponent implements OnInit {

  tareaForm!: FormGroup;
  tareaId!: number;
  mensajeModal: string = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private tareasService: TareasService,
    private router: Router
  ) {}

  ngOnInit() {
    this.tareaId = +this.route.snapshot.paramMap.get('id')!;

    this.tareaForm = this.fb.group({
      fullname: ['', Validators.required],
      description: ['', Validators.required],
      categoria: ['', Validators.required],
      fechaCreacion: ['', Validators.required]
    });

    this.tareasService.getTareaById(this.tareaId).subscribe({
      next: tarea => {
        this.tareaForm.patchValue({
          fullname: tarea.fullname,
          description: tarea.description,
          categoria: tarea.categoria,
          fechaCreacion: tarea.fechaCreacion
        });
      },
      error: err => {
        this.mensajeModal = 'No se pudo cargar la tarea.';
        console.error(err);
      }
    });
  }

  actualizarTarea() {
    if (this.tareaForm.invalid) {
      this.mensajeModal = 'Por favor, complete todos los campos correctamente.';
      return;
    }

    const tareaActualizada: Tarea = {
      id: this.tareaId,
      ...this.tareaForm.value,
      isFinished: false
    };

    this.tareasService.updateTarea(this.tareaId, tareaActualizada).subscribe({
      next: () => {
        this.mensajeModal = 'Tarea actualizada correctamente.';
        setTimeout(() => {
          this.router.navigate(['/home']);
        }, 2);
      },
      error: err => {
        this.mensajeModal = 'Error al actualizar la tarea.';
        console.error(err);
      }
    });
  }
}
