import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppGreeting } from './components/app-greeting/app-greeting';
import { ProductCard } from './components/product-card/product-card';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AppGreeting, ProductCard],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  //1st product
  productName = 'watch'
  productPrice = '299.99'
  productImage = 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=500&auto=format&fit=crop&q=60'
  productDescription = 'watch for tracking your health. It has a sleek design and is water resistant. Perfect for sports and outdoor activities.'
  isProductNew = true
  isProductHotSale = false
  isProductSale = false

  //2nd product
  productName2 = 'phone'
  productPrice2 = '599.99'
  productImage2 = 'https://images.unsplash.com/photo-1523206489230-c012c64b2b48?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D'
  productDescription2 = 'Iphone 14. Perfect for communication and entertainment. Great camera and battery life. Perfect for daily use.'
  isProductNew2 = false
  isProductHotSale2 = true
  isProductSale2 = false

  //3rd product
  productName3 = 'Moisturizing cream'
  productPrice3 = '29.99'
  productImage3 = 'https://images.unsplash.com/photo-1763503834047-ac85c4105c0b?q=80&w=580&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D'
  productDescription3 = 'Moisturizing cream for dry skin. Contains shea butter and vitamin E. Helps to hydrate and protect the skin.'
  isProductNew3 = false
  isProductHotSale3 = false
  isProductSale3 = true

  //4th product
  productName4 = 'Red Nike Sneaker'
  productPrice4 = '99.99'
  productImage4 = 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=870&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D'
  productDescription4 = 'Red Nike Sneaker for daily use. Comfortable and stylish. Perfect for sports and outdoor activities.'
  isProductNew4 = false
  isProductHotSale4 = false
  isProductSale4 = false
}
