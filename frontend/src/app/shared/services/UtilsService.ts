import { Injectable } from "@angular/core";
import { CookieService } from "ngx-cookie-service";

@Injectable()
export class UtilsService {

    constructor(private cookieService: CookieService) {}

    public getUserLogged(): string {
        const { username } = JSON.parse(this.cookieService.get('userLogged'));

        return username;
    }

}