import { Task } from "./Task";

export class Category {
    private _id: number;
    private _name: string;
    private _global: boolean;
    private _active: boolean;
    private _creatorId: number;
    private _tasks: Array<Task> = [];

    constructor() {

    }
    
    public static serialize(category: Category) {
        if (category != null) {
            let tasks: any[];

            tasks = [];
            category._tasks.forEach(function (task) {
            tasks.push(Task.serialize(task));
            });

            return {
                id: category._id,
                name: category._name,
                global: category._global,
                active: category._active,
                creatorId: category._creatorId,
                tasks: tasks
            }
        } else {
            return null;
        }
    }

    public static deserialize(input: any): Category {
        var res = new Category();
        res._id = input._id;
        res._name = input._name;
        res._global = input._global;
        res._creatorId = input._creatorId;
        
        let tasks = input._tasks;

        for (var i = 0; i < tasks.length; i++) {
            res._tasks.push(Task.deserialize(tasks[i]));
        }

        return res;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get global(): boolean {
        return this._global;
    }

    set global(value: boolean) {
        this._global = value;
    }

    get active(): boolean {
        return this._active;
    }

    set active(value: boolean) {
        this._active = value;
    }

    get creatorId(): number {
        return this._creatorId;
    }

    set creatorId(value: number) {
        this._creatorId = value;
    }

    get tasks(): Array<Task> {
        return this._tasks;
    }

    set tasks(value: Array<Task>) {
        this._tasks = value;
    }
}