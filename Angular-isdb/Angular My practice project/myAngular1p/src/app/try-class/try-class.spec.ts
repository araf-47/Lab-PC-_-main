import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TryClass } from './try-class';

describe('TryClass', () => {
  let component: TryClass;
  let fixture: ComponentFixture<TryClass>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TryClass],
    }).compileComponents();

    fixture = TestBed.createComponent(TryClass);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
