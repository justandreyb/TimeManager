import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { TokenService } from "./TokenService";
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/map';
import { CookiesService } from "./CookiesService";

@Injectable()
export class HTTPService {
    constructor(private http: Http) {

    }

    public getData(url: string) {
        let headers = this.getHeaders();
        return this
            .http
            .get(url, { headers: headers })
            .map((data) => data.json());
    }

    public getDataWithParametr(url: string,  tail: string) {
        let headers = this.getHeaders();
        return this
            .http
            .get(url + tail, { headers: headers })
            .map((data) => data.json());
    }

    public sendData(url: string,  data: any) {
        let headers = this.getSendHeaders();
        alert("Data: " + JSON.stringify(data));
        return this
            .http
            .post(url, JSON.stringify(data), { headers: headers })
            .map((response) => response.json());
    }

    private getSendHeaders() {
        let result = new Headers();
        result.append('Content-Type', 'application/json');
        if (this.getToken() !== "") {
            result.append('token', this.getToken());
        }
        return result;
    }

    private getHeaders() {
        let result = new Headers();
        if (this.getToken() !== "") {
            result.append('token', this.getToken());
        }
        return result;
    }

    public getToken() {
		if (TokenService.getToken() !== "") {
			return TokenService.getToken();
		} else {
			return CookiesService.getCookie("token");
		}

	}

	public setToken(token : string) {
		TokenService.setToken(token);
		CookiesService.setCookie("token", token, 3600 * 24, "/");
	}

	public deleteToken() {
		TokenService.setToken("");
		CookiesService.deleteCookie("token");
	}
}