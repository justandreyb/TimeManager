import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { ProfileComponent } from "./profile.component";
import { ProfileInfoComponent } from "./inner/information/profile-information.component";
import { ProfileEditComponent } from "./inner/edit/edit-profile.component";

import { projectRoutes } from './inner/project/project.routing';

export const profileRoutes : Routes = [
    {
        path: 'profiles',
        component: ProfileComponent,
        children: [
            {
                path: ':profileId',
                component: ProfileInfoComponent
            },
            {
                path: ':profileId/edit',
                component: ProfileEditComponent
            },
            {
                path: ':profileId/projects',
                children: [...projectRoutes]
            }
        ]
    }
];

export const profileRouting: ModuleWithProviders = RouterModule.forRoot(profileRoutes);

