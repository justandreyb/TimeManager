import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { HTTPService } from "../../../../../../services/HTTPService";
import { EmployerAccount } from '../../../../../../beans/account/EmployerAccount';
import 'rxjs/Rx';

@Component({
    selector: 'sing-up-company',
    templateUrl: 'src/app/components/authentication/inner/sign-up/inner/employer/employer.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/panel.css',
        'src/app/assets/form.css'
    ]
})

export class SignUpCompanyComponent {

    private rePass: string;

    private account = new EmployerAccount();

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
        this.httpService.sendData("/registration/company", EmployerAccount.serialize(this.account))
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            })
            .subscribe((response) => {
                alert("Response: " + response);
                this.servResponse = response;
                this.httpService.setToken(this.servResponse.token);
                this.router.navigate(['/accounts/login']);
                return null;
            });
    }
    
}