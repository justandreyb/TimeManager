import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router';

import { ResumeComponent } from "./resume.component";
import { ResumeEditComponent } from "./inner/edit/edit-resume.component";
import { ResumesUserComponent } from "./inner/user/resume-user.component";
import { ResumeCreateComponent } from "./inner/create/create-resume.component";

export const resumeRoutes : Routes = [
    {
        path: '',
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: ResumesUserComponent
            },
            {
                path: 'create',
                component: ResumeCreateComponent
            },
            {
                path: ':resumeId',
                component: ResumeComponent
            },
            {
                path: ':resumeId/edit',
                component: ResumeEditComponent
            }
        ]
    },
];

export const resumeRouting: ModuleWithProviders = RouterModule.forRoot(resumeRoutes);