import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { TaskModule } from './inner/task/task.module';

import { ProjectComponent } from "./project.component";
import { ProjectsComponent } from './inner/list/list-project.component';
import { ProjectEditComponent } from './inner/edit/edit-project.component';
import { ProjectInfoComponent } from './inner/information/project.information.component';
import { ProjectCreateComponent } from './inner/create/create-project.component';

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule,

        TaskModule
    ],
    declarations: [
        ProjectComponent,
        ProjectsComponent,
        ProjectInfoComponent,
        ProjectEditComponent,
        ProjectCreateComponent
    ],
    exports: [
        ProjectComponent,
        ProjectsComponent,
        ProjectInfoComponent,
        ProjectEditComponent,
        ProjectCreateComponent
    ]
})

export class ProjectModule {}
