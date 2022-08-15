import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "src/app/shared/models/User";

@Injectable()
export class LoginService {

    constructor(private http: HttpClient) {}

    private url = 'http://localhost:8080/api/user'

    public authUser(user: User): Observable<any> {
        return this.http.post(`${this.url}/auth`, user).pipe(res => res);
    }

}