import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { SignUpComponent } from './sign-up.component'
import { SignUpUserComponent } from './inner/user/user.component'
import { SignUpMainComponent } from "./inner/main/sign-up-main.component";
import { SignUpCompanyComponent } from './inner/employer/employer.component'

export const signUpRoutes : Routes = [
    {
        path: "",
        component: SignUpComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                redirectTo: 'main'
            },
            {
                path: 'main',
                component: SignUpMainComponent
            },
            {
                path: 'user',
                component: SignUpUserComponent
            },
            {
                path: 'company',
                component: SignUpCompanyComponent
            }
        ]
    }
];

export const SignUpRouting: ModuleWithProviders = RouterModule.forRoot(signUpRoutes);