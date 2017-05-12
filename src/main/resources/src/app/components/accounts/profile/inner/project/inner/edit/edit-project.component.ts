import { Component } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';
import {Resume} from "../../../../../../../beans/resume/Resume";
import {HTTPService} from "../../../../../../../services/HTTPService";
import {Router} from "@angular/router";

@Component({
    selector: 'profile__resumes__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/edit/edit-project.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ResumeEditComponent {

    private resume = new Resume();

    constructor(
        private httpService: HTTPService,
        private router: Router
    ) { }

    public editResume() {
        // add data validation if need (but on server side it was)
        // TODO: ADD USER ID TO this.resume FROM TOKEN!!!!
        this.sendRequest();
    }

    private sendRequest() {
        this.httpService.sendData("/edit/resume", Resume.serialize(this.resume))
            .catch((error) => {
                alert("Something went wrong. Try again later. Error: " + error);
                return null;
            });
    }
}