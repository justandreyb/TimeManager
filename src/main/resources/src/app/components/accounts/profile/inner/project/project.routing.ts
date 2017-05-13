import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { ProjectComponent } from './project.component';
import { ProjectEditComponent } from './inner/edit/edit-project.component';
import { ProjectCreateComponent } from './inner/create/create-project.component';
import { ProjectsComponent } from './inner/list/list-project.component';
import { ProjectInfoComponent } from "./inner/information/project.information.component";


export const projectRoutes : Routes = [
    {
        path: '',
        component: ProjectComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: ProjectsComponent
            },
            {
                path: 'create',
                component: ProjectCreateComponent
            },
            {
                path: ':projectId',
                component: ProjectInfoComponent
            },
            {
                path: ':projectId/edit',
                component: ProjectEditComponent
            }
        ]
    },
];

export const projectRouting: ModuleWithProviders = RouterModule.forRoot(projectRoutes);