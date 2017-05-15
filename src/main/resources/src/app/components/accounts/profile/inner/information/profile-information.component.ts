import 'rxjs/Rx';
import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { Component, OnInit } from '@angular/core';

import { User } from "../../../../../model/User";

import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__information',
    templateUrl: 'src/app/components/accounts/profile/inner/information/profile-information.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProfileInfoComponent implements OnInit {
    
    private account = new User();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    private loadAccount() {
        if (this.userService.getUserId() != null) { 
            let path = "/users/" + this.userService.getUserId();
            alert(path);
            this.httpService.getData("/users/" + this.userService.getUserId())
                .catch((error) => {
                    alert("Something went wrong !!! Error: " + error);
                    return null;
                })
                .subscribe((response) => {
                    this.account = User.deserialize(response);
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/auth/login"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}