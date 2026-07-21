import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./header/header";

@Component({
  selector: 'app-root',
  imports: [Header],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('myAngular1p');
  time: string = new Date().toLocaleTimeString('en-US', { 
    hour: '2-digit', 
    minute: '2-digit' 
  });

  course = "Angular Basics";
  
  imgLink: string = "https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExaHU1dncycmJzcnVwcjd4cmw3eWIydDI5YmRhZmYwMDE0eDhpcDJwYSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/cl2PsDEg80omBDkq8G/giphy.gif";
}
