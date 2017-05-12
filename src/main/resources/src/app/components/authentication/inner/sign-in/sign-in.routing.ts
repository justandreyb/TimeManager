import { ModuleWithProviders } from '@angular/core/core';
import { Routes, RouterModule } from '@angular/router'

import { SignInComponent } from './sign-in.component'
import { SignInMainComponent } from "./inner/main/sign-in-main.component";
import { SignInUserComponent } from './inner/user/user-login.component'
import { SignInCompanyComponent } from './inner/employer/employer-login.component'

export const signInRoutes : Routes = [
    {
        path: "",
        component: SignInComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                redirectTo: 'main'
            },
            {
                path: 'main',
                component: SignInMainComponent
            },
            {
                path: 'user',
                component: SignInUserComponent
            },
            {
                path: 'company',
                component: SignInCompanyComponent
            }
        ]
    }
];

export const SignInRouting: ModuleWithProviders = RouterModule.forRoot(signInRoutes);