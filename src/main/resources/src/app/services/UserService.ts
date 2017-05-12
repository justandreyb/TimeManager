import { Injectable } from '@angular/core';

import { HTTPService } from "./HTTPService";

@Injectable()
export class UserService {

    constructor(
        private httpService: HTTPService
    ) { }

    public getUserNick(): string {
        var token = this.httpService.getToken();
        if(token != "") {
            return this.decodeToken(token)["NICKNAME"];
        }

        return "";
    }

    public getUserId(): number {
        var token = this.httpService.getToken();
        if(token != "") {
            return this.decodeToken(token)["USER_ID"];
        }

        return 0;
    }

    public isAdmin(): boolean {
        var token = this.httpService.getToken();
        if(token != "") {
            return this.decodeToken(token)["IS_ADMIN"];
        }
        return false;
    }

    public isUser(): boolean {
        var token = this.httpService.getToken();
        if(token != "") {
            return this.decodeToken(token)["IS_USER"];
        }
        return false;
    }

    public isCompany(): boolean {
        var token = this.httpService.getToken();
        if(token != "") {
            return this.decodeToken(token)["IS_COMPANY"];
        }
        return false;
    }

    public isAuth(): boolean {
        var token = this.httpService.getToken();
        if(token === "")
            return false;
        else
            return true;
    }

    private decodeToken(token: String): any {
        if (typeof token != "undefined") {
            var encodeString = token.split(".")[1];
            var decodeObject = JSON.parse(atob(encodeString));
            return decodeObject;
        } else {
            return "";
        }
    }

}