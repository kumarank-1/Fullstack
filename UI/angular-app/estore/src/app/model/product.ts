export class Product {
  constructor(
    public productId: number,
    public name: string,
    public price: number,
    public rating: number,
    public category: string
  ) {}
}