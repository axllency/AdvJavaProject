import { Component } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'web-client';

  isUserLoggedIn() {
    let user = sessionStorage.getItem('token')
    return !(user === null)
}

logOut() {
    sessionStorage.removeItem('token')
  }
}
