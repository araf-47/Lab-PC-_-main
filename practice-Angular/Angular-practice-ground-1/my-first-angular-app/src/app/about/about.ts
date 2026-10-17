import { Component } from '@angular/core';
import { signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-about',
  styleUrl: './about.css',
  templateUrl: './about.html',
})
export class About {
  // angular signals
  // counter with signal
  count = signal(0);

  increase() {
    this.count.update(value => value + 1);
    // this.count.set(47);
  }
  decrease() {
    this.count.update(value => value - 1);
  }
  reset() {
    this.count.set(0);
  }

  
  // normal count example
  normalCount = 0;
  
  increaseNormal() {
    this.normalCount++;
  }
  resetNormal() {
    this.normalCount = 0;
  }

  // boolean signal example
  isLoggedIn = signal<boolean | null>(null);

  toggleLogin() {
    this.isLoggedIn.set(true);
  }
  toggleLogout() {
    this.isLoggedIn.set(false);
  }

}
