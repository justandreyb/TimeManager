import 'rxjs/Rx';
import { Router, ActivatedRoute } from "@angular/router";
import { Component, OnInit, OnDestroy } from '@angular/core';

import { Project } from "../../../../../../../model/Project";

import { HTTPService } from "../../../../../../../services/HTTPService";
import { UserService } from "../../../../../../../services/UserService";

@Component({
    selector: 'profile__projects__project__edit',
    templateUrl: 'src/app/components/accounts/profile/inner/project/inner/information/project.information.component.html',
    styleUrls: [
        'src/app/assets/grid.css',
        'src/app/assets/form.css',
        'src/app/assets/panel.css'
    ]
})

export class ProjectInfoComponent implements OnInit, OnDestroy {

    private id: number;
    private userId: number;

    private sub: any;
    private project: Project;

    constructor(
        private httpService: HTTPService,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
            this.id = +params['projectId']; 
            this.userId = +params['userId']; 
            
            this.loadProject(this.userId, this.id);
        });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    private loadProject(userId: number, id: number) {
        if (this.userService.getUserId() == userId) { 
            this.httpService.getData("/users/" + userId + "/projects/" + id)
                .catch((error) => {
                    alert("Something went wrong");
                    return null;
                })
                .subscribe((response) => {
                    this.project = Project.deserialize(response);
                    this.project.id = this.id;
                    return null;
                });
        } else {
            alert("You are not logged in.");
            this.router.navigate(["/auth/login"]);
        }
    }
}