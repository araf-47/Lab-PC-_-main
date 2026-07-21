import { Component } from '@angular/core';

@Component({
  selector: 'app-try-class',
  imports: [],
  templateUrl: './try-class.html',
  styleUrl: './try-class.css',
})
export class TryClass {
  ngOnInit() {
    localStorage.setItem('Araf', '47');
    sessionStorage.setItem('ArTabOnly', '47+1-1');
  }
}
