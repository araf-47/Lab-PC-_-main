import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AppGreeting } from './app-greeting';

describe('AppGreeting', () => {
  let component: AppGreeting;
  let fixture: ComponentFixture<AppGreeting>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppGreeting],
    }).compileComponents();

    fixture = TestBed.createComponent(AppGreeting);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
