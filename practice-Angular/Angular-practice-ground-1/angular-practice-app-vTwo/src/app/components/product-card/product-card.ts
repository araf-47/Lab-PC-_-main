import { Component, input } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-product-card',
  styleUrl: './product-card.css',
  templateUrl: './product-card.html',
})
export class ProductCard {
  productName = input('Unknown Product');
  productPrice = input('0.00');
  productImage = input('unknown.jpg');
  productDescription = input('No description available');

  isProductNew = input(false);
  isProductHotSale = input(false);
  isProductSale = input(false);

  alart(){
    alert('🖕 Fuck you');
  }
}
