import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { ProjectComponent } from "./project.component";


@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        ProjectComponent,
        ProjectEditComponent,
        ProjectUserComponent,
        ProjectCreateComponent,
    ],
    exports: [
        ProjectComponent,
        ProjectEditComponent,
        ProjectUserComponent,
        ProjectCreateComponent,
    ]
})

export class ProjectModule {}
