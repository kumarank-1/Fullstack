import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-weclocme',
  imports: [],
  templateUrl: './weclocme.html',
  styleUrl: './weclocme.css',
})
export class Weclocme {
  title = 'Wclocome to Welcome compomennt';

  @Input()
  name!: string;
}
