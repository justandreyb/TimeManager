import { Task } from "./task";

export class Category {
    id: number;
    name: string;
    global: boolean;
    active: boolean;
    creatorId: number;
    tasks: Array<Task> = [];

    constructor() {

    }
    
    static deserialize(input: any): Category {
        var res = new Category();
        res.id = input.id;
        res.name = input.name;
        res.global = input.global;
        res.creatorId = input.creatorId;
        
        let tasks = input.tasks;

        for (var i = 0; i < tasks.length; i++) {
            res.tasks.push(Task.deserialize(tasks[i]));
        }

        return res;
    }
}