import { Component, OnInit } from '@angular/core';
import { Vinyl } from '../services/Vinyl';
import { ApiService } from '../services/vinyl.service';

@Component({
  selector: 'app-update-vinyl',
  templateUrl: './update-vinyl.component.html',
  styleUrls: ['./update-vinyl.component.css']
})
export class UpdateVinylComponent implements OnInit {

  constructor(private vinyService: ApiService) { }
  vinyl = new Vinyl();
  id: any;

  ngOnInit(): void {
  }

  getVinyl(id:any){
    this.vinyService.getVinyl(id).subscribe(data =>{
      this.vinyl = data
    })
  }

  updateVinyl(id:any){
    this.vinyService.updateVinyl(id,this.vinyl)
  }
}
