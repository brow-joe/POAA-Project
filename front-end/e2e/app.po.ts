import { browser, by, element } from 'protractor';

/*
* Classe que representa a obtencao dos componentes para realizar os testes
* com protactor
* @author Lucas Costa <lbc.lucascosta@gmail.com>
* @since 23/11/2017
*/

export class AppPage {
  navigateToCliente() {
    return browser.get('/');
  }

  navigateToLivro() {
    return browser.get('/livro');
  }

  getInput() {
    return element(by.css('app-root input')).getText();
  }

  getButton() {
    return element(by.css('app-root button')).getText();
  }
}
