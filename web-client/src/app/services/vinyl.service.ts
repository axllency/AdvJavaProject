import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vinyl } from './Vinyl';

@Injectable({providedIn:'root'})
export class ApiService {

    //Base url
    url: string = '';


    constructor(private http: HttpClient) {
    }

    getAllVinyls(): Observable<Vinyl[]>{
        return this.http.get<Vinyl[]>(this.url + 'vinyl')
    }
    getVinyl(id:any): Observable<Vinyl>{
        return this.http.get<Vinyl>(this.url+'vinyl/'+id)
    }
    addVinyl(vinyl:Vinyl){
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(vinyl);
        this.http.post(this.url + 'vinyl', body,{'headers':headers})
    }
    updateVinyl(id:any,vinyl:Vinyl){
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(vinyl);
        this.http.put(this.url + 'vinyl/'+id,body,{'headers':headers})

    }
    deleteVinyl(id:any){
        this.http.delete(this.url+'vinyl/'+id)
    }
}