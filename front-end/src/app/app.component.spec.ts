import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component'; // para testar main
import { MenuComponent } from './menu/menu.component'; // para testar criacao do componente menu
import { RouterTestingModule } from '@angular/router/testing'; // testar rotas

/*
* Rotinas de teste unitario para o componente principal (App) com Karma
* @author Lucas Costa <lbc.lucascosta@gmail.com>
* @since 22/11/2017
*/

describe('AppComponent', () => {

    beforeEach(async (() => {
      TestBed.configureTestingModule({
          imports: [
              RouterTestingModule
          ],
          declarations: [
              AppComponent,
              MenuComponent
          ],
      }).compileComponents();
  }));

  // testar criacao do componente
  it('App precisa ser criado', async (() => {
      const fixture = TestBed.createComponent(AppComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app).toBeTruthy();
  }));

  // testar criacao do componente menu
  it('Menu precisa ser criado', async (() => {
      const fixture = TestBed.createComponent(MenuComponent);
      const app = fixture.debugElement.componentInstance;
      expect(app).toBeTruthy();
  }));
});
