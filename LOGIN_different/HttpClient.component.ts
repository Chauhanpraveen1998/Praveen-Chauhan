import { HttpClient } from '@angular/common/http';

constructor(private http: HttpClient) { }

onSubmit() {
  const credentials = {
    email: this.loginForm.get('email').value,
    password: this.loginForm.get('password').value
  };

  this.http.post('/api/login', credentials, { withCredentials: true }).subscribe(response => {
    // handle successful login
  });
}
