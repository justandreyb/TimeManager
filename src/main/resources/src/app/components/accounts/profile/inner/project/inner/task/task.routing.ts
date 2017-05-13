import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { TaskComponent } from "./task.component";


export const taskRoutes : Routes = [
    {
        path: '',
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: TaskComponent
            },
            {
                path: 'create',
                component: ProjectCreateComponent
            },
            {
                path: ':taskId',
                component: ProjectComponent
            },
            {
                path: ':taskId/edit',
                component: ProjectEditComponent
            }
        ]
    },
];

export const taskRouting: ModuleWithProviders = RouterModule.forRoot(taskRoutes);