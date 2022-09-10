import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UtilsService } from "src/app/shared/services/UtilsService";

@Injectable()
export class UploaderService {

    constructor(
        private http: HttpClient,
        private utilsService: UtilsService
    ) {}

    private url = 'http://localhost:8080/api/site-uploader'

    public uploadFile(siteName: string, siteFile: FormData): Observable<any> {
        const userName = this.utilsService.getUserLogged();
        
        return this.http.post(`${this.url}?userName=${userName}&siteName=${siteName}`, siteFile)
            .pipe(res => res);;
    }

}