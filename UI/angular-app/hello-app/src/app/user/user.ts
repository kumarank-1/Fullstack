import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule, JsonPipe } from '@angular/common';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule, FormsModule, JsonPipe],
  templateUrl: './user.html',
  styleUrls: ['./user.css']
})
export class User {
  user = {
    email: '',
    password: ''
  };

  onSubmit() {
    console.log('Form Submitted!', this.user);
  }
}
