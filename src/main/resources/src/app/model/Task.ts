import { Category } from "./Category";

export class Task {
    private _id: number;
    private _name: string;
    private _description: string;
    private _deleted: boolean;
    private _importance: number;
    private _finished: number;
    private _complexity: number;
    private _urgency: number;
    private _category: Category;

    constructor() {

    }

    public static serialize(task: Task) {
        if (task != null) {
            return {
                id: task._id,
                name: task._name,
                description: task._description,
                deleted: task._deleted,
                importance: task._importance,
                finished: task._finished,
                complexety: task._complexity,
                urgency: task._urgency,
                category: Category.serialize(task._category)
            }
        } else {
            return null;
        }
    }

    public static deserialize(input: any): Task {
        let res = new Task();

        res._id = input.id;
        res._name = input.name;
        res._deleted = input.deleted;
        res._description = input.description;
        res._importance = input.importance;
        res._finished = input.finished;
        res._complexity = input.complexety;
        res._urgency = input.urgency;
        res._category = Category.deserialize(input.category);
        
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

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get deleted(): boolean {
        return this._deleted;
    }

    set deleted(value: boolean) {
        this._deleted = value;
    }

    get importance(): number {
        return this._importance;
    }

    set importance(value: number) {
        this._importance = value;
    }

    get finished(): number {
        return this._finished;
    }

    set finished(value: number) {
        this._finished = value;
    }

    get complexity(): number {
        return this._complexity;
    }

    set complexity(value: number) {
        this._complexity = value;
    }

    get urgency(): number {
        return this._urgency;
    }

    set urgency(value: number) {
        this._urgency = value;
    }

    get category(): Category {
        return this._category;
    }

    set category(value: Category) {
        this._category = value;
    }
}