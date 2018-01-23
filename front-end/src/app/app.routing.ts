import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { ArticleComponent } from './articles/article.component';

/*
* Rotas e componentes que deverao responder por elas no menu
* @author Lucas Costa <lbc.lucascosta@gmail.com>
*/

const MAINMENU_ROUTES: Routes = [
    { path: '', redirectTo: '/article', pathMatch: 'full' },
    { path: 'article', component: ArticleComponent }
];
export const CONST_ROUTING = RouterModule.forRoot(MAINMENU_ROUTES);
