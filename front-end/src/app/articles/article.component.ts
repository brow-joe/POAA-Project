import { Component, OnInit } from '@angular/core';
import { SharedService } from '../shared.service';

/*
* Article component that will be renderized on /article route
* @author Lucas Costa <lbc.lucascosta@gmail.com>
*/

@Component({
  selector: 'app-livro',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.less'],
  styles: []
})
export class ArticleComponent implements OnInit {
    obj: Object = {};
    search: String = '';
    alert: Boolean = false;
    articles = [];

    constructor(private _sharedService: SharedService) {}

    ngOnInit() {
        this.callArticleService();
    }

    callArticleService() {
        
        this._sharedService.findArticles()
            .subscribe(
                lstresult => {
                    this.articles = lstresult.content;
                    this._handleAlert(this.articles);
                },
                error => {
                    this._handleAlert(this.articles);
                    console.log('Error', error);
                }
            );
    }

    createArticleService() {
        
        this._sharedService.createArticle(this.obj)
            .subscribe(
                lstresult => {
                    this.callArticleService();
                    alert('Saved!')
                },
                error => {
                    this._handleAlert(this.articles);
                    console.log('Error', error);
                }
            );
    }

    deleteArticleService(obj: Object) {
        
        this._sharedService.deleteArticle(obj)
            .subscribe(
                lstresult => {
                    this.callArticleService();
                    console.log('Removed!')
                },
                error => {
                    this._handleAlert(this.articles);
                    console.log('Error', error);
                }
            );
    }

    // flag que manipula o alerta em caso de nenhum registro encontrado
    _handleAlert(articles) {
        articles.length ? this.alert = false : this.alert = true;
    }
}
