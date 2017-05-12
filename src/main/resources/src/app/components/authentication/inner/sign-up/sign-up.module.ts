import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';

import { SignUpComponent } from './sign-up.component';
import { SignUpUserComponent } from "./inner/user/user.component";
import { SignUpCompanyComponent } from "./inner/employer/employer.component";
import { SignUpMainComponent } from './inner/main/sign-up-main.component';

@NgModule({
    imports: [
        BrowserModule,
        RouterModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        SignUpComponent,
        SignUpUserComponent,
        SignUpMainComponent,
        SignUpCompanyComponent,
    ],
    exports: [
        SignUpComponent,
        SignUpUserComponent,
        SignUpMainComponent,
        SignUpCompanyComponent
    ]
})

export class SignUpModule {}
