import 'rxjs/Rx';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";

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

export class TaskCreateComponent {
    
    private task = new Task();
    private userId: number;
    private projectId: number;

    private sub: any;
    // Mb just static var
    private currentDate = this.getCurrentDate();

    constructor(
        private httpService: HTTPService,
        private userService: UserService, 
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
                this.userId = +params['userId']; 
                this.projectId = +params['projectId']; 
            });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    public createTask() {
        this.sendRequest();
    }

    private sendRequest() {
        if (this.userService.isAuth()){
            this.httpService.sendData("users/" + this.userService.getUserId() + "/projects/" + this.projectId + "/tasks/create", Task.serialize(this.task))
                .catch((error) => {
                    alert("Something went wrong while creating task. Error: " + error);
                    return null;
                })
                .subscribe(() => {
                    this.router.navigate(["../"]);
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