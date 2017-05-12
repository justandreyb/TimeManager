import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ProfileModule } from "../components/accounts/profile/profile.module";
import { AuthenticationModule } from '../components/authentication/authentication.module';

import { HelpComponent } from "../components/main/help/help.component";
import { FooterComponent } from '../components/main/page-footer/page-footer.component';
import { WelcomeComponent } from "../components/main/welcome/welcome.component";
import { NavigationComponent } from '../components/main/navigation/navigation.component';
import { ApplicationComponent } from "./app.component";
import { PathNotFoundComponent } from "../components/errors/not-found/not-found.component";

import { rootRouting } from "./app.routing";

import { UserService } from "../services/UserService";
import { HTTPService } from '../services/HTTPService';
import { TokenService } from '../services/TokenService';
import { CookiesService } from '../services/CookiesService';

@NgModule({
    imports: [
        BrowserModule,
        
        ProfileModule,
        AuthenticationModule,
        
        rootRouting
    ],
    declarations: [
        HelpComponent,
        FooterComponent,
        WelcomeComponent,
        NavigationComponent,        
        ApplicationComponent,
        PathNotFoundComponent
    ],
    providers: [
        UserService,
        HTTPService,
        TokenService,
        CookiesService
    ],
    bootstrap: [ 
        ApplicationComponent 
    ]
})

export class AppModule {
    constructor() { }
}
