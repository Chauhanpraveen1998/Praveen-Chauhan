import { Component } from '@angular/core';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  email: string;
  password: string;
  csrfToken: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCsrfToken().subscribe(data => {
      this.csrfToken = data['_csrf'];
    });
  }

  onSubmit() {
    this.authService.login(this.email, this.password, this.csrfToken);
  }

}
