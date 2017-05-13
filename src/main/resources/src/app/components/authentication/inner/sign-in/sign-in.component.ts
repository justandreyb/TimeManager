import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { User } from '../../../../model/User';

import { HTTPService } from "../../../../services/HTTPService";
import { UserService } from "../../../../services/UserService";

@Component({
    selector: 'login',
    templateUrl: 'src/app/components/authentication/inner/sign-in/sign-in.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class SignInComponent implements OnInit {

    private rePass: string;

    private account = new User();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router    
    ) { }

    public signIn() {
        if (this.account.password == this.rePass) {
        
            if (this.account.email != null) {
                this.sendData();
            } else {
                alert("Email is not correct");
            }
        } else {
            alert("Password and re: doesn't match");
        }
    }

    private sendData() {
        this.httpService.sendData("/login", User.serialize(this.account))
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                alert("Response: " + response);
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.router.navigate(['/welcome']);
                return null;
            });
    }

    ngOnInit() { }
}