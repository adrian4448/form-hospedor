import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CookieService } from "ngx-cookie-service";
import { Observable } from "rxjs";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    constructor(private cookieService: CookieService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const userLogged = this.cookieService.get('userLogged');
        if (userLogged) {
            const { token } = JSON.parse(this.cookieService.get('userLogged'));
            if (userLogged) {
                request = request.clone({
                    setHeaders: { Authorization: `Bearer ${token}` }
                });
            }
        }

        return next.handle(request);
    }

}