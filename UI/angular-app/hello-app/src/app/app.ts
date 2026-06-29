import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Weclocme } from './weclocme/weclocme';
import { User } from './user/user';
import { Customer } from './customer/customer';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule,Weclocme,User,Customer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('hello-app');

  name : string = "rahul";
  role = "teacher"

}
