export class Result {
    text: string;

    constructor() {

    }

    static deserialize(input: any): Result {
        var res = new Result();
        res.text = input.text;
        return res;
    }
}