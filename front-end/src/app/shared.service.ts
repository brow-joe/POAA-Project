import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

/*
* Classe que representa os servicos que iram consumir a API REST
* @author Lucas Costa <lbc.lucascosta@gmail.com>
*/

@Injectable()
export class SharedService {
    // URL Padrao
    API_URL_ROOT = 'http://localhost:5000';
    // Endpoints
    API_URL_ARTICLES = this.API_URL_ROOT + '/api/v1/filter/';

    constructor(private _http: Http) { }

    findArticles() {
        return this._http.get(this.API_URL_ARTICLES)
            .map(response => {
                {
                    return response.json();
                }
            })
            .catch(error => Observable.throw(error.json()));
    }

    createArticle(obj: Object) {
        return this._http.post(this.API_URL_ARTICLES, obj)
            .map(response => {
                {
                    return response.json();
                }
            })
            .catch(error => Observable.throw(error.json()));
    }

    deleteArticle(obj: Object) {
        return this._http.delete(this.API_URL_ARTICLES + obj['id'])
            .map(response => {
                {
                    return response.json();
                }
            })
            .catch(error => Observable.throw(error.json()));
    }
}
