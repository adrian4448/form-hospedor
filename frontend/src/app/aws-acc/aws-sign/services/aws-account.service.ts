import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AwsAccountInfo } from "src/app/shared/models/AwsAccountInfo";
import { User } from "src/app/shared/models/User";

@Injectable()
export class AwsAccountService {

    private url = "http://localhost:8080/api/aws_account_info";

    constructor(private http: HttpClient) {}

    findAwsAccountInfoByUser(user: User): Observable<AwsAccountInfo> {
        return this.http.get<AwsAccountInfo>(`${this.url}/${user.id}`)
            .pipe(res => res);
    }

    createAwsAccountInfo(awsAccountInfo: AwsAccountInfo, userId: number) {
        const awsAccoutInfoCreate = {
            accessKey: awsAccountInfo.accessKey,
            secretKey: awsAccountInfo.secretKey,
            user: userId
        };

        return this.http.post<AwsAccountInfo>(this.url, awsAccoutInfoCreate)
            .pipe(res => res);
    }

}