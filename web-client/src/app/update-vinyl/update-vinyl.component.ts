import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-vinyl',
  templateUrl: './update-vinyl.component.html',
  styleUrls: ['./update-vinyl.component.css']
})
export class UpdateVinylComponent implements OnInit {

  constructor() { }
  id: any;
  title: any;
  artist: any;
  releaseDate: any;
  serial: any;
  recordLabel: any;
  vinylcondition: any;

  ngOnInit(): void {
  }

  updateVinyl(id,title, artist,releaseDate, serial, recordLabel, vinylcondition){

  }
}
