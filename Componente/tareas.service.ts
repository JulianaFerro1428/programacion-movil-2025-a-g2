import { Injectable } from "@angular/core";
import { Tarea } from "./tarea";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable, tap } from "rxjs";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class TareasService {
  private urlEndpoint = `${environment.apiUrl}/todolist/tareas`;

  private tareasSubject = new BehaviorSubject<Tarea[]>([]);
  tareas$ = this.tareasSubject.asObservable();

  constructor(private http: HttpClient) {}

  eliminarTareaAlFinalizar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndpoint}/${id}/finalizar`);
  }

  obtenerTareas(): void {
    const usuario = JSON.parse(localStorage.getItem('usuario') || '{}');
    const idUsuario = usuario.id;

    if (!idUsuario) {
      console.error('No se encontró el ID del usuario en localStorage');
      return;
    }

    const url = `${environment.apiUrl}/todolist/usuarios/${idUsuario}/tareas`;

    this.http.get<Tarea[]>(url).subscribe(data => {
      this.tareasSubject.next(data);
    });
  }

  create(tarea: Tarea): Observable<Tarea> {
    return new Observable(observer => {
      this.http.post<Tarea>(this.urlEndpoint, tarea).subscribe({
        next: nuevaTarea => {
          const tareasActuales = this.tareasSubject.value;
          this.tareasSubject.next([...tareasActuales, nuevaTarea]);
          observer.next(nuevaTarea);
          observer.complete();
        },
        error: err => observer.error(err),
      });
    });
  }

  finalizarTarea(id: number): Observable<Tarea> {
    return this.http.put<Tarea>(`${this.urlEndpoint}/${id}/finalizar`, {}).pipe(
      tap(finalizada => {
        const tareasActuales = this.tareasSubject.value.map(t =>
          t.id === id ? finalizada : t
        );
        this.tareasSubject.next(tareasActuales);
      })
    );
  }

  borrarTarea(id: number): Observable<any> {
    return this.http.delete(`${this.urlEndpoint}/${id}`);
  }

  getTareaById(id: number): Observable<Tarea> {
    return this.http.get<Tarea>(`${this.urlEndpoint}/${id}`);
  }

  updateTarea(id: number, tarea: Tarea): Observable<Tarea> {
    return this.http.put<Tarea>(`${this.urlEndpoint}/${id}`, tarea).pipe(
      tap(tareaActualizada => {
        const tareasActuales = this.tareasSubject.value.map(t =>
          t.id === id ? tareaActualizada : t
        );
        this.tareasSubject.next(tareasActuales);
      })
    );
  }
}
