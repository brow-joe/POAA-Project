import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component'; // importando componente menu
import { ArticleComponent } from './articles/article.component'; // importando componente Article

import { CONST_ROUTING } from './app.routing'; // importanto rotas
import { SharedService } from './shared.service'; // importando servicos

/*
* Modulo App que ira conter os dois componentes (Menu e Articles)
* @author Lucas Costa <lbc.lucascosta@gmail.com>
*/

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    CONST_ROUTING
  ],
  providers: [SharedService],
  bootstrap: [AppComponent]
})
export class AppModule { }
