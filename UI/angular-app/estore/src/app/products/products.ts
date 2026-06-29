import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { Product } from '../model/product';
import { ProductsService } from '../services/products';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];
  showProducts = true;
  categories: string[] = ['Electronics', 'Fashion', 'Accessories', 'Books'];

  productForm = new FormGroup({
    productId: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    rating: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required)
  });

  constructor(private productsService: ProductsService) {}

  ngOnInit(): void {
    this.products = this.productsService.getProducts();
  }

  toggleView(): void {
    this.showProducts = !this.showProducts;
  }

  onSubmit(): void {
    if (this.productForm.valid) {
      const v = this.productForm.value;
      const newProduct = new Product(
        Number(v.productId),
        v.name ?? '',
        Number(v.price),
        Number(v.rating),
        v.category ?? ''
      );

      this.products.push(newProduct);
      this.productForm.reset();
    }
  }
}