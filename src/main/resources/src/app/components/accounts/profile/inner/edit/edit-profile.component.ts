import { Router } from '@angular/router';
import { HTTPService } from '../../../../../services/HTTPService';
import { Component, OnInit } from '@angular/core';

import { User } from '../../../../../model/User';

import { UserService } from "../../../../../services/UserService";

@Component({
    selector: 'profile__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/edit/edit-profile.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProfileEditComponent implements OnInit {
    
    private pass: string;

    private account = new User();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public editUser() {
        if (this.account.email != "" && this.account.email.includes("@")) {
            if (this.account.password == this.pass) {
                
                this.sendRequest();
            } else {
                alert("Password doesn't match");
            }
        } else {
            alert("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/users/" + this.userService.getUserId() + "/edit", User.serialize(this.account))
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((answer) => {
                if (answer != null && answer.error != null) {
                    alert(answer.error);
                } else {
                    this.router.navigate(["../"]);
                }
            });
    }

    private loadAccount() {
        if (this.userService.getUserId() != null) {
            let path = "/users/" + this.userService.getUserId();
            alert(path);
            this.httpService.getData(path)
                .catch((error) => {
                    alert("Something went wrong !!");
                    return null;
                })
                .subscribe((response) => {
                    alert(response.toString());
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