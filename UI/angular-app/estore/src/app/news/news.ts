import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-news',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './news.html',
  styleUrl: './news.css'
})
export class NewsComponent implements OnInit {
  apiUrl = 'https://jsonplaceholder.typicode.com/posts';
  newsData: any[] = [];

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.httpClient.get<any[]>(this.apiUrl).subscribe({
      next: (response) => {
        this.newsData = response.slice(0, 5);
        console.log('News API Response:', response);
      },
      error: (error) => {
        console.error('HTTP Error:', error);
      }
    });
  }
}