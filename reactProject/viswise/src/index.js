import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {BrowserRouter} from "react-router-dom";
import {Redirect, Route, Switch} from "react-router";
import {App} from "./containers/App";


ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
        <App>
            <Switch>

            </Switch>
        </App>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);


