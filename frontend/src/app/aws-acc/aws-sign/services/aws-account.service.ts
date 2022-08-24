import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CookieService } from "ngx-cookie-service";
import { Observable } from "rxjs";
import { AwsAccountInfo } from "src/app/shared/models/AwsAccountInfo";
import { User } from "src/app/shared/models/User";
import { UtilsService } from "src/app/shared/services/UtilsService";

@Injectable()
export class AwsAccountService {

    private url = "http://localhost:8080/api/aws-account-info";

    constructor(
        private http: HttpClient,
        private utilsService: UtilsService
    ) {}

    findAwsAccountInfoByUser(): Observable<AwsAccountInfo> {
        const userName = this.utilsService.getUserLogged();

        return this.http.get<AwsAccountInfo>(`${this.url}?userName=${userName}`)
            .pipe(res => res);
    }

    createAwsAccountInfo(awsAccountInfo: AwsAccountInfo) {
        const userName = this.utilsService.getUserLogged();
        const awsAccoutInfoCreate = {
            accessKey: awsAccountInfo.accessKey,
            secretKey: awsAccountInfo.secretKey,
            user: { userName }
        };

        return this.http.post<AwsAccountInfo>(this.url, awsAccoutInfoCreate)
            .pipe(res => res);
    }

}