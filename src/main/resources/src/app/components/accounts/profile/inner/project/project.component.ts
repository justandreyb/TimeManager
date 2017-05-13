import 'rxjs/Rx';
import { Http } from '@angular/http';
import { Component } from '@angular/core';

import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__projects',
    templateUrl: 'src/app/components/accounts/profile/inner/project/project.component.html'
})

export class ProjectComponent {
    constructor (
        private userService: UserService
    ) { }
}