import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'

import { AuthenticationComponent } from "./authentication.component";
import { AuthenticationMainComponent } from "./inner/main/authentication-main.component";

import { SignInComponent } from './inner/sign-in/sign-in.component';
import { SignUpComponent } from "./inner/sign-up/sign-up.component";

export const authenticationRoutes : Routes = [
    {
        path: 'auth',
        component: AuthenticationComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                redirectTo: 'main'
            },
            {
                path: 'main',
                component: AuthenticationMainComponent
            },
            {
                path: 'login',
                component: SignInComponent
            },
            {
                path: 'registration',
                component: SignUpComponent
            }
        ]
    }
];

export const authenticationRouting: ModuleWithProviders = RouterModule.forRoot(authenticationRoutes);
