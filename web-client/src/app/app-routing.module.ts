import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateVinylComponent } from './create-vinyl/create-vinyl.component';
import { DeleteVinylComponent } from './delete-vinyl/delete-vinyl.component';
import { FindVinylComponent } from './find-vinyl/find-vinyl.component';
import { LoginComponent } from './login/login.component';
import { UpdateVinylComponent } from './update-vinyl/update-vinyl.component';

const routes: Routes = [
  {path: '',redirectTo: '/login',pathMatch:'full'},
  {path: 'create', component:CreateVinylComponent},
  {path: 'delete', component:DeleteVinylComponent},
  {path: 'update', component:UpdateVinylComponent},
  {path: 'find', component:FindVinylComponent},
  {path: 'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
