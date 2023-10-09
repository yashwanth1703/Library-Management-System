import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwBookComponent } from './veiw-book.component';

describe('VeiwBookComponent', () => {
  let component: VeiwBookComponent;
  let fixture: ComponentFixture<VeiwBookComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VeiwBookComponent]
    });
    fixture = TestBed.createComponent(VeiwBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
