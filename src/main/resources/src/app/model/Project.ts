import { Task } from "./Task";

export class Project {
    private _id: number;
    private _name: string;
    private _startDate: Date;
    private _deadline: Date;
    private _importance: number;
    private _finished: boolean;
    private _deleted: boolean;
    private _tasks: Array<Task> = [];
    
    constructor() {

    }

    public static serialize(project: Project) {
        if (project != null) {
            let tasks: any[];

            tasks = [];
            project._tasks.forEach(function (task) {
                tasks.push(Task.serialize(task));
            });

            return {
                id: project._id,
                name: project._name,
                startDate: project._startDate,
                deadline: project._deadline,
                importance: project._importance,
                finished: project._finished,
                deleted: project._deleted,
                tasks: tasks
            }
        } else {
            return null;
        }
    }

    public static deserialize(input: any): Project {
        var res = new Project();
        res._id = input.id;
        res._name = input.name;
        res._startDate = input.startDate;
        res._deadline = input.deadline;
        res._importance = input.importance;
        res._finished = input.finished;
        res._deleted = input.deleted;
        
        let tasks = input.tasks;
        if (tasks != null) {
            for (var i = 0; i < tasks.length; i++) {
                res._tasks.push(Task.deserialize(tasks[i]));
            }
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

    get startDate(): Date {
        return this._startDate;
    }

    set startDate(value: Date) {
        this._startDate = value;
    }

    get deadline(): Date {
        return this._deadline;
    }

    set deadline(value: Date) {
        this._deadline = value;
    }

    get importance(): number {
        return this._importance;
    }

    set importance(value: number) {
        this._importance = value;
    }

    get finished(): boolean {
        return this._finished;
    }

    set finished(value: boolean) {
        this._finished = value;
    }

    get deleted(): boolean {
        return this._deleted;
    }

    set deleted(value: boolean) {
        this._deleted = value;
    }

    get tasks(): Array<Task> {
        return this._tasks;
    }

    set tasks(value: Array<Task>) {
        this._tasks = value;
    }
}