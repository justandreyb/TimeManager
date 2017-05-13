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

    public deleteUser() {

    }

    private loadAccount() {
        if (this.userService.getUserId() != null) { 
            this.httpService.getData("/profile/" + this.userService.getUserId())
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.account = response;
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/accounts/login/user"]);
        }
    }

    ngOnInit() { 
        this.loadAccount();
    }
}