import { ProjectInfoComponent } from './inner/information/project.information.component';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { ProjectComponent } from "./project.component";
import { ProjectsComponent } from './inner/list/list-project.component';
import { ProjectCreateComponent } from './inner/create/create-project.component';
import { ProjectEditComponent } from './inner/edit/edit-project.component';

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
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
