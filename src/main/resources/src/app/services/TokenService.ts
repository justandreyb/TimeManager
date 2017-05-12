export class TokenService {
    private static _token: string;

    public static getToken(): string {
        if (this._token == null) {
            return "";
        } else {
            return this._token;
        }
    }

    public static setToken(value: string) {
        this._token = value;
    }

}