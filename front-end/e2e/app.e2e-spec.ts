import { AppPage } from './app.po';

/*
* Execucao dos casos de testes com protactor
* @author Lucas Costa <lbc.lucascosta@gmail.com>
* @since 23/11/2017
*/

describe('blue-hunter-library App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('tela de cliente deve conter um botao', () => {
    page.navigateToCliente();
    expect(page.getButton()).toEqual('Buscar');
  });

  it('tela de cliente deve conter um campo de pesquisa', () => {
    page.navigateToCliente();
    expect(page.getInput()).toEqual('');
  });

  it('tela de livro deve conter um botao', () => {
    page.navigateToLivro();
    expect(page.getButton()).toEqual('Buscar');
  });

  it('tela de livro deve conter um campo de pesquisa', () => {
    page.navigateToLivro();
    expect(page.getInput()).toEqual('');
  });
});
