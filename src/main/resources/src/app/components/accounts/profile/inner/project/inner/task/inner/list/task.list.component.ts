import 'rxjs/Rx';
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Task } from '../../../../../../../../../model/Task';

import { HTTPService } from "../../../../../../../../../services/HTTPService";
import { UserService } from "../../../../../../../../../services/UserService";

@Component({
    selector: 'profile__projects__tasks__list',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/list/list-project.component.html'
})

export class ProjectsComponent {

    private projectId: number;
    private sub: any;

    private tasks = new Array<Task>();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }
    
    ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
        this.projectId = +params['projectId']; 
        
        this.loadTasks(this.projectId);
        });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    private loadTasks(projectId: number) {
        if (this.userService.getUserId() != null) {
            this.httpService.getData("/users/" + this.userService.getUserId() + "/projects" + projectId + "/tasks")
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((data) => {
                    this.deserializeResponse(data);
                    return null;
                })
        } else {
            alert("You are not logged in");
        }
    }

    private deserializeResponse(response: any) {
        let tasksJSON = JSON.parse(response);
        tasksJSON.forEach(function(element: any) {
            let task = Task.deserialize(element);
            this.projects.push(task);
        });
    }

}