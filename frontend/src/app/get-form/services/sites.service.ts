import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs"
import { UtilsService } from "src/app/shared/services/UtilsService";

@Injectable()
export class SitesService {

    constructor (
        private http: HttpClient,
        private utilsService: UtilsService
    ) {}

    private url = 'http://localhost:8080/api/site-info'

    public getAllSitesInfo(page: number, size: number): Observable<any> {
        const userName = this.utilsService.getUserLogged();

        return this.http.get(`${this.url}?page=${page}&size=${size}`)
            .pipe(res => res);
    }

}