import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/Rx';

import { Router } from "@angular/router";

import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from "../../../../../../../services/HTTPService";

import { Project } from "../../../../../../../model/Project";

@Component({
    selector: 'profile__projects__project__create',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/create/create-project.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProjectCreateComponent {
    
    private project = new Project();

    // Mb just static var
    private currentDate = this.getCurrentDate();

    constructor(
        private httpService: HTTPService,
        private userService: UserService, 
        private router: Router
    ) { }

    public createProject() {
        this.sendRequest();
    }

    private sendRequest() {
        if (this.userService.isAuth()){
            this.httpService.sendData("/users/" + this.userService.getUserId() + "/projects/create", Project.serialize(this.project))
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
        } else {
            alert("You are not logged in");
        }
    }

    private getCurrentDate(): string {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();

        let final = yyyy.toString();
        if (mm < 10) {
            final = final + "-0";
        } else {
            final = final + "-";
        }
        final = final + mm.toString();

        if (dd < 10) {
            final = final + "-0";
        } else {
            final = final + "-";
        }
        final = final + dd.toString();

        return final;
    }
}