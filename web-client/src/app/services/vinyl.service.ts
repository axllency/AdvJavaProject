import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vinyl } from './Vinyl';

@Injectable({providedIn:'root'})
export class ApiService {

    //Base url
    url: string = 'http://musicprojectdeployment.us-east-2.elasticbeanstalk.com/music/';


    constructor(private http: HttpClient) {
    }

    getAllVinyls(): Observable<Vinyl[]>{
        return this.http.get<Vinyl[]>(this.url + 'vinyl')
    }
    getVinyl(id:any): Observable<Vinyl>{
        return this.http.get<Vinyl>(this.url+'vinyl/'+id)
    }
    addVinyl(vinyl:Vinyl){
        const headers = {'Content-Type': 'application/json'}  
        const body=JSON.stringify(vinyl);
        return this.http.post<any>(this.url + 'vinyl', body,{'headers':headers})
    }
    updateVinyl(id:any,vinyl:Vinyl){
        const headers = {'Content-Type': 'application/json'}  
        const body=JSON.stringify(vinyl);
        return this.http.put<any>(this.url + 'vinyl/'+id,body,{'headers':headers})

    }
    deleteVinyl(id:any){
        return this.http.delete<any>(this.url+'vinyl/'+id)
    }
}