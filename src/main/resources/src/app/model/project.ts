import { Task } from "./task";
import { User } from "./user";

export class Project {
    id: number;
    name: string;
    startDate: Date;
    deadline: Date;
    importance: number;
    finished: boolean;
    deleted: boolean;
    user: User;
    tasks: Array<Task> = [];
    constructor() {

    }

    static deserialize(input: any): Project {
        var res = new Project();
        res.id = input.id;
        res.name = input.name;
        res.startDate = input.startDate;
        res.deadline = input.deadline;
        res.importance = input.importance;
        res.finished = input.finished;
        res.deleted = input.deleted;
        res.user = User.deserialize(input.user);
        
        let tasks = input.tasks;

        for (var i = 0; i < tasks.length; i++) {
            res.tasks.push(Task.deserialize(tasks[i]));
        }

        return res;
    }
}