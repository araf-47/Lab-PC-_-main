import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header implements OnInit {
  ngOnInit(): void {
    console.log("=================================");
    console.log("Header initialized");
    console.log("=================================");
    console.log('Current time:', new Date().toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit' }));
    console.log('Current date:', new Date().toLocaleDateString('en-US', { year: 'numeric', month: '2-digit', day: '2-digit' }));
    console.log("=================================");
  }
}
