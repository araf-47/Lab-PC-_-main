import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-home',
  styleUrl: './home.css',
  templateUrl: './home.html',
})
export class Home {
  imageUrl = 'https://www.edmunds.com/assets/m/cs/cms/8a4e860a-cebe-4074-99b8-11c42d53de00/2026-lamborghini-revuelto-01-f34-07282025-edmunds_1280.jpg';
  name = 'Lamborghini Revuelto';
  price = 610000;

  isDisabled = false;

  onButtonClick() {
    alert('🥵やめてください');
  }

  count = 0;

  increase() {
    this.count++;
  }
  reset() {
    this.count = 0;
  }

  wifeName = '';

  mathScore: number = 0;

  digitalDevices = ['mobile', 'tablet', 'laptop', 'desktop', 'smartwatch', 'smartphone', 'tv'];
  fruits = [
    {id: 1, name: 'apple'},
    {id: 2, name: 'banana'},
    {id: 3, name: 'orange'},
    {id: 4, name: 'grape'},
    {id: 5, name: 'strawberry'},
    {id: 6, name: 'blueberry'},
    {id: 7, name: 'raspberry'}
  ];

  favoriteColor = '';
}
