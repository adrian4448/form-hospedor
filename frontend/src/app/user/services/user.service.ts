import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User } from "src/app/shared/models/User";

@Injectable()
export class UserService {

    constructor(private http: HttpClient) {}

    private url = 'http://localhost:8080/api/user'

    public authUser(user: User): Observable<any> {
        return this.http.post(`${this.url}/auth`, user).pipe(res => res);
    }

    public registerUser(user: User) {
        return this.http.post(`${this.url}`, user).pipe(res => res);
    }

}