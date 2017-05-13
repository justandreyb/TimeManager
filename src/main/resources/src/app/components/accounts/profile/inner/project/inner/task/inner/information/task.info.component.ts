import 'rxjs/Rx';
import { Router, ActivatedRoute } from "@angular/router";
import { Component, OnInit, OnDestroy } from '@angular/core';

import { Task } from '../../../../../../../../../model/Task';

import { HTTPService } from "../../../../../../../../../services/HTTPService";
import { UserService } from "../../../../../../../../../services/UserService";


@Component({
    selector: 'profile__projects__tasks__task__info',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/edit/edit-project.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class TaskInfoComponent implements OnInit, OnDestroy {

    private id: number;
    private userId: number;
    private projectId: number;

    private sub: any;
    private task: Task;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            this.id = +params['taskId']; 
            this.userId = +params['userId']; 
            this.projectId = +params['projectId']; 
            
            this.loadTask(this.userId, this.projectId, this.id);
            });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    private loadTask(userId: number, projectId: number, id: number) {
        if (this.userService.getUserId() == userId) { 
            this.httpService.getData("/users/" + userId + "/projects/" + projectId + "/tasks/" + id)
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.task = Task.deserialize(response);
                    this.task.id = this.id;
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/auth/login"]);
        }
    }
}