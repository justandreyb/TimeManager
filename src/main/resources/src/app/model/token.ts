export class Token {
    value: string;

    constructor () {}

    static deserialize(input : any) : Token {
        var res = new Token();
        res.value = input.value;
        return res;
    } 
}