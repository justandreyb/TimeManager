import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

import { Router } from "@angular/router";

import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from "../../../../../../../services/HTTPService";

@Component({
    selector: 'profile__resumes__create',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/create/create-project.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ResumeCreateComponent {

    private resume = new Resume();
    private rePass: string;

    constructor(
        private httpService: HTTPService,
        private userService: UserService, 
        private router: Router
    ) { }

    public createResume() {
        // add data validation if need (but on server side it was)
        // TODO: ADD USER ID TO this.resume FROM TOKEN!!!!
        this.sendRequest();
    }

    private sendRequest() {
        // if (this.userService.isUser()){
            this.httpService.sendData("/add/resume", Resume.serialize(this.resume))
                .catch((error) => {
                    alert("Something went wrong. Try again later. Error: " + error);
                    return null;
                });
        // } else {
        //     alert("You are not logged in");
        // }
    }
}