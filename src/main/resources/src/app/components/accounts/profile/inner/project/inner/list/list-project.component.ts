import 'rxjs/Rx';
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Project } from "../../../../../../../model/Project";

import { UserService } from '../../../../../../../services/UserService';
import { HTTPService } from '../../../../../../../services/HTTPService';

@Component({
    selector: 'profile__projects__list',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/list/list-project.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProjectsComponent {

    private projects: Project[];

    private userId: number;

    private sub: any;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
                this.userId = +params['userId']; 
                
                this.loadProjects(this.userId);
            });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    private loadProjects(userId: number) {
        if (this.userService.getUserId() == userId) {
            this.httpService.getData("/users/" + userId + "/projects")
                .catch((error) => {
                    alert("Something went wrong while getting projects. Error: " + error);
                    return null;
                })
                .subscribe((data) => {
                    alert(data.toString());
                    this.deserializeResponse(data);
                    return null;
                })
        } else {
            alert("Permission denied");
        }
    }

    private deserializeResponse(response: any) {
        let projectsJSON = response;
        let projects = new Array<Project>();

        projectsJSON.forEach(function(element: any) {
            let project = Project.deserialize(element);
            projects.push(project);
        });
        
        this.projects = projects;
    }

}