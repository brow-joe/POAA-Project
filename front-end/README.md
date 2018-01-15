# Blue Hunter Library

SPA application based on Angular 4 and Typescript 2 who consume data from a Node API. It has a menu with two options for a search of clients and books as can demonstrate the Angular router.

### Live

The website is hosted on [Heroku](https://www.ibm.com/cloud-computing/bluemix/pt) and available [here](https://goo.gl/5oAQMa). The REST API is available [here](https://goo.gl/aP9R3g) and has the follows *endpoints*:
 * **GET /user** clients list
 * **GET /user/by-name/{name}** search clients by name. The condition applied is *contains*
 * **GET /book** books list
 * **GET /book/by-title/{title}** search books by name. The condition applied is *contains*
 * **GET /book/by-author/{author}** search books by author. The condition applied is *contained*

### Built with

  * [Angular CLI](https://github.com/angular/angular-cli) version 1.5.3.
  * [Angular](https://angular.io/) version 4
  * [Less](lesscss.org)
  * [Typescript](https://www.typescriptlang.org/) version 2.4.2
  * [NodeJS](https://nodejs.org/en/) version 8.9.1 LTS
  * [NPM](https://www.npmjs.com/) version 5.5.1
  * [MongoDB](https://www.mongodb.com/) version 3.6
  * [ExpressJS](http://expressjs.com/pt-br/) version 4
  * [Karma](https://karma-runner.github.io/1.0/index.html), [Protactor](http://www.protractortest.org/#/), [MochaJS](https://mochajs.org/), [ChaiJS](http://chaijs.com/) for tests

Before to clone this repository, it's recommended certify if all dependencies are installed (some of them global, as Angular CLI and Typescript)

The use of MongoDB as database is because to match with NodeJS at API development. The ExpressJS framework provides some advantages as turn the development with NodeJS more productive, provide a default file structure and utils third part library. It's used Twitter Bootstrap styles too (that's compiled by Less) to transform the page friendly. At least, Mocha and Chai available easily the unit tests of application *endpoints*, Karma with Jasmine with components tests and Protactor for E2E tests.

### Development environment

The repository contains two directories on the root. The first, **blue-hunter-library-api** is where we can find the NodeJS with ExpressJS. Before to run the front end application it's necessary to start the API.

### Back-end

To run the API, first of all, it's necessary to be sure as NodeJS and MongoDB are installed. This repository follows on the root two *json* files that are the files with the necessary data for MongoDB. 
 * Create a database named **blue-hunter-library** (on *localhost* or remote server, only is necessary to fix the correctly URI on the file [db_connect.js](https://github.com/luccascosta/blue-hunter-library/blob/master/blue-hunter-library-api/app/libs/db_connect.js) and the authentication).
 * Create two *collections* on MongoDB named *customers* and *books*. Then import the file **blue_hunter.customers.json** into *customers* and **blue_hunter.books.json** into *books*.
 * On the root of Node API, run the command ```npm install``` to install the dependencies.
 * Even on the root of API, run ```npm start``` to start. Then go to the *browser* and test the *endpoints* specified above available on *localhost:8080*
 
  #### Running unit tests
 
 To execute the unit tests with Mocha e Chai, run `npm test`.

 ___
 ### Front-end
 
 * With NodeJS and NPM installed, go to command line and run `npm i -g @angular/cli@1.5.3`.
 Go to **blue-hunter-library** directory and staying on the root run `npm install` to install the dependencies. After done, run `ng serve`. The go to `http://localhost:4200/`. The app will be available and any change in the code will be reflected directly on the page.

 #### Running unit tests
 
 To execute the unit tests by [Karma](https://karma-runner.github.io), run `ng test` staying on **blue-hunter-library**.
 
 #### Running the end-to-end testes with Protactor
 
 Run `ng e2e` staying on **blue-hunter-library**.


### Build

Run `ng build` to generate the project build. The artifacts will be available on `dist/` directory. Use the `--prod` argument to *build* on production.

*Built with VS Code 1.10*
