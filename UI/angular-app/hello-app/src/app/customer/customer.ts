import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './customer.html',
  styleUrl: './customer.css'
})
export class Customer {
  submitted = false;
  customerForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.customerForm = this.fb.group({
      customerId: ['', Validators.required],
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
      city: ['', Validators.required]
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.customerForm.valid) {
      console.log(this.customerForm.value);
      this.customerForm.reset();
      this.submitted = false;
    }
  }
}