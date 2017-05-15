import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { TaskComponent } from "./task.component";
import { TasksComponent } from "./inner/list/task.list.component";
import { TaskInfoComponent } from './inner/information/task.info.component';
import { TaskEditComponent } from "./inner/edit/task.edit.component";
import { TaskCreateComponent } from "./inner/create/task.create.component";


export const taskRoutes : Routes = [
    {
        path: '',
        component: TaskComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: TasksComponent
            },
            {
                path: 'create',
                component: TaskCreateComponent
            },
            {
                path: ':taskId',
                component: TaskInfoComponent
            },
            {
                path: ':taskId/edit',
                component: TaskEditComponent
            }
        ]
    },
];

export const taskRouting: ModuleWithProviders = RouterModule.forRoot(taskRoutes);