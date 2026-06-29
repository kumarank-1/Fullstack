import { Injectable } from '@angular/core';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  getProducts(): Product[] {
    return [
      new Product(101, 'Laptop', 65000, 4.5, 'Electronics'),
      new Product(102, 'Phone', 30000, 4.2, 'Electronics'),
      new Product(103, 'Shoes', 2500, 4.0, 'Fashion'),
      new Product(104, 'Watch', 5000, 4.3, 'Accessories')
    ];
  }
}