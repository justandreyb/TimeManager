export class Role {
    id: number;
    value: string;

    constructor () {

    }

    static deserialize(input: any) :Role {
        var res = new Role();
        res.id = input.id;
        res.value = input.value;
        return res;
    }
}