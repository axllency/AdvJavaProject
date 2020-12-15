import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/vinyl.service';

@Component({
  selector: 'app-delete-vinyl',
  templateUrl: './delete-vinyl.component.html',
  styleUrls: ['./delete-vinyl.component.css']
})
export class DeleteVinylComponent implements OnInit {

  constructor(private vinyService: ApiService) { }

  id: any;

  ngOnInit(): void {
  }

  deleteVinyl(id:any){
    this.vinyService.deleteVinyl(id).subscribe()
  }
}
