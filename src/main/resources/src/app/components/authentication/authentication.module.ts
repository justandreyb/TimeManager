import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SignInComponent } from './inner/sign-in/sign-in.component';
import { SignUpComponent } from "./inner/sign-up/sign-up.component";
import { AuthenticationComponent } from './authentication.component';
import { AuthenticationMainComponent } from "./inner/main/authentication-main.component";

import { UserService } from "../../services/UserService";
import { HTTPService } from '../../services/HTTPService';

import { authenticationRouting } from "./authentication.routing";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,

        authenticationRouting
    ],
    exports: [
        SignInComponent,
        SignUpComponent,
        AuthenticationComponent,
        AuthenticationMainComponent
    ],
    declarations: [
        SignInComponent,
        SignUpComponent,
        AuthenticationComponent,
        AuthenticationMainComponent
    ],
    providers: [
        HTTPService
    ],
})

export class AuthenticationModule { }
