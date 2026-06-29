import { Routes } from '@angular/router';
import { HomeComponent } from './home/home';
import { ProductsComponent } from './products/products';
import { ProfileComponent } from './profile/profile';
import { NewsComponent } from './news/news';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, title: 'Home' },
  { path: 'products', component: ProductsComponent, title: 'Products' },
  { path: 'profile', component: ProfileComponent, title: 'Profile' },
  { path: 'news', component: NewsComponent, title: 'News' },
  { path: '**', redirectTo: 'home' }
];