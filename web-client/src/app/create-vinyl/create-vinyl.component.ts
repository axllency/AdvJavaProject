import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-vinyl',
  templateUrl: './create-vinyl.component.html',
  styleUrls: ['./create-vinyl.component.css']
})
export class CreateVinylComponent implements OnInit {

  constructor() { }

  title: any;
  artist: any;
  releaseDate: any;
  serial: any;
  recordLabel: any;
  vinylcondition: any;
  ngOnInit(): void {
  }
  createVinyl(title,artist,releaseDate,serial,recordLabel,vinylcondition){
    console.log(vinylcondition)
  }

}
