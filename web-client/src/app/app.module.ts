import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateVinylComponent } from './create-vinyl/create-vinyl.component';
import { UpdateVinylComponent } from './update-vinyl/update-vinyl.component';
import { DeleteVinylComponent } from './delete-vinyl/delete-vinyl.component';
import { FindVinylComponent } from './find-vinyl/find-vinyl.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateVinylComponent,
    UpdateVinylComponent,
    DeleteVinylComponent,
    FindVinylComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
