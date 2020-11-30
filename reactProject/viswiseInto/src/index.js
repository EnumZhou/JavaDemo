import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {CustomizedApp} from "./components/CustomizedApp";
import {BrowserRouter} from "react-router-dom";
import {Redirect, Route, Switch} from "react-router";
import {Courses} from "./components/courses";
import {About} from "./components/about";
import {Contact} from "./components/contact";
import Testimonials from "./components/testimonials";
import Team from "./components/Team";

ReactDOM.render(
  <React.StrictMode>
      <BrowserRouter>
          <CustomizedApp>
              <Switch>
                  <Route path='/about' component={About}/>
                  <Route path='/contact' component={Contact} />
                  <Route path='/courses' component={Courses} />
                  <Route path='/testimonials' component={Testimonials} />
                  <Route path='/team' component={Team} />

                  <Route path='*'>
                      <Redirect to='/about' />
                  </Route>
              </Switch>
          </CustomizedApp>
      </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
