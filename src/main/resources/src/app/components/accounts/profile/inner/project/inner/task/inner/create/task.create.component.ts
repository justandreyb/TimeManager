import 'rxjs/Rx';
import { Router } from "@angular/router";
import { Component, OnInit } from '@angular/core';

import { Task } from "../../../../../../../../../model/Task";

import { HTTPService } from "../../../../../../../../../services/HTTPService";
import { UserService } from "../../../../../../../../../services/UserService";


@Component({
    selector: 'profile__projects__tasks__task__create',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/task/inner/create/task.create.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProjectCreateComponent {
    
    private task = new Task();

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
            this.httpService.sendData("/add/resume", this.task)
                .catch((error) => {
                    alert("Something went wrong. Try again later. Error: " + error);
                    return null;
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

        return yyyy + '/' + mm + '/' + dd;
    }
}