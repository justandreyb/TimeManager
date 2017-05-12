import { Component } from "@angular/core";

import { UserService } from '../../../services/UserService';

@Component({
    selector: "profile",
    templateUrl: "src/app/components/accounts/profile/profile.component.html",
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/panel.css'
    ]
})

export class ProfileComponent {
    constructor (
        private userService: UserService
    ) { }
}