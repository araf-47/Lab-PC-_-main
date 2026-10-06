import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  // protected readonly title = signal('Amar Angular App.');
  
  imageUrl = 'https://www.edmunds.com/assets/m/cs/cms/8a4e860a-cebe-4074-99b8-11c42d53de00/2026-lamborghini-revuelto-01-f34-07282025-edmunds_1280.jpg';
  name = 'Lamborghini Revuelto';
  price = 610000;

  isDisabled = false;

  //event binding
  onButtonClick() {
    alert('🥵やめてください');
  }
  
  //event binding - counter
  count = 0;
  
  increase() {
    this.count++;
  }
  reset() {
    this.count = 0;
  }
  
  //two-way binding
  wifeName = '';
}
