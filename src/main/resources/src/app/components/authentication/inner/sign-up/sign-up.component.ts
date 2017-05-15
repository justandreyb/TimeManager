import 'rxjs/Rx';
import { Router } from '@angular/router';
import { Component } from '@angular/core';

import { User } from "../../../../model/User";

import { HTTPService } from "../../../../services/HTTPService";

@Component({
    selector: 'registration',
    templateUrl: 'src/app/components/authentication/inner/sign-up/sign-up.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/panel.css',
        'src/app/assets/form.css'
    ]
})

export class SignUpComponent {
    
    private rePass: string;

    private account = new User();

    private servResponse: any;

    constructor(
        private httpService: HTTPService,
        private router: Router    
    ) { }

    public signUp() {
        if (this.account.email != "" && this.account.email.includes("@")) {
            if (this.account.password == this.rePass) {
                this.sendRequest();
            } else {
                alert("Password and re: doesn't match");
            }
        } else {
            alert("Email isn't correct");
        }
    }

    private sendRequest() {
        this.httpService.sendData("/registration", User.serialize(this.account))
            .catch((error) => {
                alert("Something went wrong while creating account. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.value);
                this.router.navigate(['/welcome']);
                return null;
            });
    }
}