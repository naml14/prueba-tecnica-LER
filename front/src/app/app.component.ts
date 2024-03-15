import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonasService } from './services/personas/personas.service';

@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  title = 'Prueba Técnica';
  personas: any;
  personaForm!: FormGroup;
  constructor(
    public fb: FormBuilder,
    public personasService: PersonasService
  ) {}
  ngOnInit(): void {
    this.personaForm = this.fb.group({
      nombre: ['', Validators.required],
      cedula: ['', Validators.required],
      apellido: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
    });
    this.personasService.getAllPersonas().subscribe(
      (res) => {
        this.personas = res;
      },
      (err) => {
        console.error(err);
      }
    );
  }
  save(): void {
    this.personasService.savePersona(this.personaForm.value).subscribe(
      (res) => {
        this.personas = this.personas.filter(
          (persona: any) => res.cedula != persona.cedula
        );
        this.personas.push(res);
        this.personaForm.reset();
      },
      (err) => {
        console.error(err);
        alert('Error al Guardar Persona');
      },
      () => {
        alert('Persona Guardada');
      }
    );
  }

  delete(persona: any) {
    this.personasService.deletePersona(persona.cedula).subscribe(
      (res) => {
        if (res === true) {
          this.ngOnInit();
        }
      },
      (err) => {
        console.error(err);
        alert('Error al Eliminar Persona');
      },
      () => {
        alert('Persona Eliminada');
      }
    );
  }

  edit(persona: any) {
    this.personaForm.setValue({
      cedula: persona.cedula,
      nombre: persona.nombre,
      apellido: persona.apellido,
      fechaNacimiento: this.dateConverterToEdit(persona.fechaNacimiento),
    });
  }

  dateConverterToEdit = (date: string) => {
    let rawDate = date.split('T')[0].split('-');
    return new Date(
      parseInt(rawDate[0]),
      parseInt(rawDate[1]) - 1,
      parseInt(rawDate[2])
    )
      .toISOString()
      .split('T')[0];
  };

  dateConverter = (date: string) => {
    let rawDate = date.split('T')[0].split('-');
    return new Date(
      parseInt(rawDate[0]),
      parseInt(rawDate[1]) - 1,
      parseInt(rawDate[2])
    ).toLocaleDateString();
  };
}
