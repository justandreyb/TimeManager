export class Role {
    private _id: number;
    private _value: string;

    constructor () {

    }

    public static serialize(role: Role) {
        if (role != null) {
            return {
                id: role._id,
                value: role._value
            }
        } else {
            return null;
        }
    }

    public static deserialize(input: any) :Role {
        let res = new Role();
        res._id = input.id;
        res._value = input.value;
        return res;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get value(): string {
        return this._value;
    }

    set value(value: string) {
        this._value = value;
    }
}