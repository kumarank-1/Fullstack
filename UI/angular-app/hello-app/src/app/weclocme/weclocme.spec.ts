import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Weclocme } from './weclocme';

describe('Weclocme', () => {
  let component: Weclocme;
  let fixture: ComponentFixture<Weclocme>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Weclocme],
    }).compileComponents();

    fixture = TestBed.createComponent(Weclocme);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
