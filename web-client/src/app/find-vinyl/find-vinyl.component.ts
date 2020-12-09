import { Component, OnInit } from '@angular/core';
import { Vinyl } from '../services/Vinyl';
import { ApiService } from '../services/vinyl.service';

@Component({
  selector: 'app-find-vinyl',
  templateUrl: './find-vinyl.component.html',
  styleUrls: ['./find-vinyl.component.css']
})
export class FindVinylComponent implements OnInit {

  constructor(private vinyService: ApiService) { }

  vinyls: Vinyl[];
  ngOnInit(): void {
    this.getAllVinyls();
  }
  getAllVinyls(){
    this.vinyService.getAllVinyls().subscribe(data =>{
      this.vinyls = data
    })
  }
}
