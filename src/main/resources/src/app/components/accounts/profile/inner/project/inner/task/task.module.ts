import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { TaskComponent } from './task.component';
import { TasksComponent } from './inner/list/task.list.component';
import { TaskInfoComponent } from './inner/information/task.info.component';
import { TaskEditComponent } from './inner/edit/task.edit.component';
import { TaskCreateComponent } from './inner/create/task.create.component';

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        TaskComponent,
        TasksComponent,
        TaskInfoComponent,
        TaskEditComponent,
        TaskCreateComponent
    ],
    exports: [
        TaskComponent,
        TasksComponent,
        TaskInfoComponent,
        TaskEditComponent,
        TaskCreateComponent
    ]
})

export class TaskModule {}
