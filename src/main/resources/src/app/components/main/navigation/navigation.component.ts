import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Router } from "@angular/router";
import { Component } from '@angular/core';

import { UserService } from '../../../services/UserService';
import { HTTPService } from '../../../services/HTTPService';

@Component({
    selector: 'navigation',
    templateUrl: 'src/app/components/main/navigation/navigation.component.html',
    styleUrls: [
        'src/app/components/main/navigation/navigation.component.css'
    ]
})

export class NavigationComponent {
    
    constructor(
        private httpService: HTTPService,
        private userService: UserService
    ) { };

    public logOut() {
        this.httpService.deleteToken();
    }

}