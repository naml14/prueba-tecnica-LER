import {
  AfterViewInit,
  Component,
  OnInit,
  Renderer2,
  ViewChild,
} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonasService } from './services/personas/personas.service';
import DataTable from 'datatables.net-bs5';
import { Router } from '@angular/router';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import $ from 'jquery';

export interface CustomTable {
  columns: any[];
  data: any[];
}

@Component({
  selector: 'root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements AfterViewInit, OnInit {
  @ViewChild(DataTableDirective, { static: false })
  dtElement: DataTableDirective | undefined;

  title = 'Prueba Técnica';
  personas: any;
  tableData: any;
  personaForm!: FormGroup;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<DataTables.Settings> = new Subject<DataTables.Settings>();

  constructor(
    public fb: FormBuilder,
    public personasService: PersonasService,
    private renderer: Renderer2,
    private router: Router
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
        let rawData: any[] = [];
        res.forEach((element: Object) => {
          rawData.push(Object.values(element));
        });
        this.personas = res;
        rawData.forEach((e) => {
          let fecha = e[3];
          e[3] = this.dateConverter(fecha);
          let opciones = `<button
          type="button"
          class="btn btn-success fs-6"
          title="Editar"
        >Editar
        </button>
        <button
          type="button"
          class="btn btn-danger fs-6"
          title="Eliminar"
          (click)="delete(persona)"
        >Eliminar
          </button>`;
          e.push(opciones);
        });
        this.tableData = rawData;
        console.log(rawData);
        new DataTable('#tablePersonas', {
          columns: [
            { title: 'Cédula' },
            { title: 'Nombres' },
            { title: 'Apellidos' },
            { title: 'Fecha de Nacimiento' },
            { title: 'Opciones' },
          ],
          data: rawData,
          destroy: true,
          searching: true,
          paging: true,
        });
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
        this.rerender();
        alert('Persona Guardada');
      }
    );
  }

  delete(persona: any) {
    this.personasService.deletePersona(persona.cedula).subscribe(
      (res) => {
        if (res === true) {
          this.rerender();
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
      fechaNacimiento: persona.fechaNacimiento,
    });
  }

  dateConverterToEdit = (date: string) => {
    let rawDate = date.split('/');
    return new Date(
      parseInt(rawDate[2]),
      parseInt(rawDate[1]) - 1,
      parseInt(rawDate[0])
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
  ngAfterViewInit(): void {
    let data: any[] = [];
    this.renderer.listen('body', 'click', (event) => {
      if (event.target.title === 'Editar') {
        event.target.parentElement.parentElement
          .querySelectorAll('td')
          .forEach(
            (element: {
              firstChild: any;
              child: any;
              childNodes: any;
              value: any;
            }) => {
              if (element.childNodes.length === 1) {
                data.push(element.firstChild.data);
              }
            }
          );
        let persona = {
          cedula: data[0],
          nombre: data[1],
          apellido: data[2],
          fechaNacimiento: this.dateConverterToEdit(data[3]),
        };
        this.edit(persona);
      }
      if (event.target.title === 'Eliminar') {
        event.target.parentElement.parentElement
          .querySelectorAll('td')
          .forEach(
            (element: {
              firstChild: any;
              child: any;
              childNodes: any;
              value: any;
            }) => {
              if (element.childNodes.length === 1) {
                data.push(element.firstChild.data);
              }
            }
          );
        let persona = {
          cedula: data[0],
          nombre: data[1],
          apellido: data[2],
          fechaNacimiento: this.dateConverterToEdit(data[3]),
        };
        this.delete(persona);
      }
    });
  }
  rerender(): void {
    let tabla = new DataTable('#tablePersonas');
    tabla.destroy();
    $('#tablePersonas').empty();
    this.ngOnInit();
  }
}
