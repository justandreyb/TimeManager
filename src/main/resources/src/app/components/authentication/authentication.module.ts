import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignUpModule } from "./inner/sign-up/sign-up.module";
import { SignInModule } from "./inner/sign-in/sign-in.module";

import { AuthenticationComponent } from './authentication.component';
import { AuthenticationMainComponent } from "./inner/main/authentication-main.component";

import { HTTPService } from '../../services/HTTPService';

import { authenticationRouting } from "./authentication.routing";
import { UserService } from "../../services/UserService";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        SignInModule,
        SignUpModule,

        authenticationRouting
    ],
    exports: [
        AuthenticationComponent,
        AuthenticationMainComponent
    ],
    declarations: [
        AuthenticationComponent,
        AuthenticationMainComponent
    ],
    providers: [
        HTTPService
    ],
})

export class AuthenticationModule { }
