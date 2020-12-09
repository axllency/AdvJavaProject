import { Component, OnInit } from '@angular/core';
import { Vinyl } from '../services/Vinyl'
import { ApiService } from '../services/vinyl.service'
@Component({
  selector: 'app-create-vinyl',
  templateUrl: './create-vinyl.component.html',
  styleUrls: ['./create-vinyl.component.css']
})
export class CreateVinylComponent implements OnInit {

  constructor(private vinyService: ApiService) { }

  vinyl = new Vinyl();

  ngOnInit(): void {
  }
  createVinyl(){
    console.log(this.vinyl)
    this.vinyService.addVinyl(this.vinyl)
  }

}
