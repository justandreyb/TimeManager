import { Project } from "./project";
import { Role } from "./role";

export class User {
    id: number;
    nickname: string;
    email: string;
    password: string;
    deleted: boolean;
    projects: Array<Project> = [];
    role: Role;

    constructor() {

    }

    static deserialize(input: any) : User {
        var res = new User();
        res.id = input.id;
        res.nickname = input.nickname;
        res.email = input.email;
        res.password = input.password;
        res.deleted = input.deleted;
        
        let projects = input.projects;

        for (var i = 0; i < projects.length; i++) {
            res.projects.push(Project.deserialize(projects[i]));
        }

        res.role = input.role;

        return res;
    }
}