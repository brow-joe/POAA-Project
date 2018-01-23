import { TestBed, async, inject } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { ArticleComponent } from './article.component'; // para testar criacao do componente livro
import { SharedService } from '../shared.service'; // para testar criacao do componente livro

/*
* Rotinas de teste unitario para o componente Article com Karma
* @author Lucas Costa <lbc.lucascosta@gmail.com>
*/

describe('BookComponent', () => {

    beforeEach(async (() => {
        TestBed.configureTestingModule({
                providers: [SharedService], // injecao do servico para requisicao no teste
                imports: [ FormsModule, HttpModule ], // modulos necessarios
                declarations: [ArticleComponent], // target
            })
            .compileComponents(); // compila template e css
    }));

    // checagem da consulta do livro
    it('Resultado nao pode ser indefinido ou nulo', async (() => {
        const fixture = TestBed.createComponent(LivroComponent);
        const article = fixture.debugElement.componentInstance;
        article.callLivroService();
        expect(article.articles.length).toBeDefined();
        expect(article.articles.length).not.toBeNull();
    }));
});
