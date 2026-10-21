import { Component, signal } from '@angular/core';


@Component({
  imports: [],
  selector: 'app-app-greeting',
  styleUrl: './app-greeting.css',
  templateUrl: './app-greeting.html',
})
export class AppGreeting {
  protected readonly title = signal('angular-practice-app-vTwo');
}
