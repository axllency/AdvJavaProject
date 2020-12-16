import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {

    url: string = 'http://musicprojectdeployment.us-east-2.elasticbeanstalk.com/music/';

    constructor(private httpClient: HttpClient) {
    }

    authenticate(username: any, password: any) {
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
        return this.httpClient.get<any>(this.url + 'vinyl', { headers }).pipe(
            map(
                data => {
                    sessionStorage.setItem('token', btoa(username + ':' + password));
                    return data;
                },
                error =>{
                    throwError
                }
            )
        );
    }

}