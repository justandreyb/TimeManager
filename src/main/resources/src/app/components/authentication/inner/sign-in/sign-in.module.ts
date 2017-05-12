import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignInComponent } from './sign-in.component';
import { SignInMainComponent } from './inner/main/sign-in-main.component';
import { SignInUserComponent } from "./inner/user/user-login.component";
import { SignInCompanyComponent } from "./inner/employer/employer-login.component";

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        SignInComponent,
        SignInUserComponent,
        SignInMainComponent,
        SignInCompanyComponent
    ],
    exports: [
        SignInComponent,
        SignInMainComponent,
        SignInUserComponent,
        SignInCompanyComponent
    ]
})

export class SignInModule {}
