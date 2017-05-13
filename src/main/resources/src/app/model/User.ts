import { Project } from "./Project";
import { Role } from "./Role";
import {userInfo} from "os";

export class User {
    private _id: number;
    private _nickname: string;
    private _email: string;
    private _password: string;
    private _deleted: boolean;
    private _projects: Array<Project> = [];
    private _role: Role;

    constructor() {

    }

    public static serialize(user: User) {
        if (user != null) {
            let projects : any[];
            projects = [];
            user._projects.forEach(function (project) {
            projects.push(Project.serialize(project));
            });

            return {
                id: user._id,
                email: user._email,
                password: user._password,
                nickname: user._nickname,
                projects: projects,
                role: Role.serialize(user._role),
            }
        } else {
            return null;
        }
    }

    static deserialize(input: any) : User {
        var res = new User();
        res._id = input.id;
        res._nickname = input.nickname;
        res._email = input.email;
        res._password = input.password;
        res._deleted = input.deleted;
        
        let projects = input.projects;

        for (var i = 0; i < projects.length; i++) {
            res._projects.push(Project.deserialize(projects[i]));
        }

        res._role = Role.deserialize(input.role);

        return res;
    }

    public addProject(project: Project) {
        this.projects.push(project);
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get nickname(): string {
        return this._nickname;
    }

    set nickname(value: string) {
        this._nickname = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get password(): string {
        return this._password;
    }

    set password(value: string) {
        this._password = value;
    }

    get deleted(): boolean {
        return this._deleted;
    }

    set deleted(value: boolean) {
        this._deleted = value;
    }

    get projects(): Array<Project> {
        return this._projects;
    }

    set projects(value: Array<Project>) {
        this._projects = value;
    }

    get role(): Role {
        return this._role;
    }

    set role(value: Role) {
        this._role = value;
    }
}