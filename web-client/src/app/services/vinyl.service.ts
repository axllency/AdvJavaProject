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
        let basicString='Basic '+ this.getHeaders()
        let headers= new HttpHeaders(
          {Authorization:basicString}
        );
        return this.http.get<Vinyl[]>(this.url + 'vinyl',{headers})
    }
    getVinyl(id:any): Observable<Vinyl>{
        let basicString='Basic '+ this.getHeaders()
        let headers= new HttpHeaders(
          {Authorization:basicString}
        );
        return this.http.get<Vinyl>(this.url+'vinyl/'+id,{headers})
    }
    addVinyl(vinyl:Vinyl){
        let basicString='Basic '+ this.getHeaders()
        let headers= new HttpHeaders(
          {Authorization:basicString}
        );
        const body=JSON.stringify(vinyl);
        return this.http.post<any>(this.url + 'vinyl', body,{headers})
    }
    updateVinyl(id:any,vinyl:Vinyl){
        let basicString='Basic '+ this.getHeaders()
        let headers= new HttpHeaders(
          {Authorization:basicString}
        );
        const body=JSON.stringify(vinyl);
        return this.http.put<any>(this.url + 'vinyl/'+id,body,{headers})

    }
    deleteVinyl(id:any){
        let basicString='Basic '+ this.getHeaders()
        let headers= new HttpHeaders(
          {Authorization:basicString}
        );
        return this.http.delete<any>(this.url+'vinyl/'+id,{headers})
    }
    getHeaders(){
        return sessionStorage.getItem('token')
      }
}