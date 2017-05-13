import 'rxjs/Rx';
import { Router } from '@angular/router';
import { Component } from '@angular/core';

import { Project } from "../../../../../../../model/Project";

import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from '../../../../../../../services/HTTPService';

@Component({
    selector: 'profile__projects__list',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/list/list-project.component.html'
})

export class ProjectsComponent {

    private projects = new Array<Project>();

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private router: Router
    ) { }
    
    ngOnInit() {
        this.loadProjects();
    }

    private loadProjects() {
        if (this.userService.getUserId() != null) {
            this.httpService.getData("/users/" + this.userService.getUserId() + "/projects")
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
        let projectsJSON = JSON.parse(response);
        projectsJSON.forEach(function(element: any) {
            let project = Project.deserialize(element);
            this.projects.push(project);
        });
    }

}