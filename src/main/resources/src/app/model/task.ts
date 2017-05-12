import { Category } from "./category";

export class Task {
    id: number;
    name: string;
    description: string;
    deleted: boolean;
    importance: number;
    finished: number;
    complexity: number;
    urgency: number;
    category: Category;

    constructor() {

    }

    static deserialize(input: any): Task {
        var res = new Task();
        res.id = input.id;
        res.name = input.name;
        res.deleted = input.deleted;
        res.importance = input.importance;
        res.finished = input.finished;
        res.complexity = input.complexety;
        res.urgency = input.urgency;
        res.category = Category.deserialize(input.category);
        return res;
    }
}