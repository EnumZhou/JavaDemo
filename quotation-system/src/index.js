import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {App} from "./container/App";
import {Switch,Route,Redirect} from "react-router";
import {BrowserRouter} from "react-router-dom";
import {appConstants} from "./constant/appConstants";
import {CustomizedTable} from "./component/CustomizedTable";


ReactDOM.render(
    <BrowserRouter>
        <App>
            <Switch>
                <Route path={appConstants.tableRoute} component={CustomizedTable}/>
                <Route path={appConstants.invalidRoute}>
                    <Redirect to={appConstants.tableRoute}></Redirect>
                </Route>
            </Switch>
        </App>
    </BrowserRouter>,
  document.getElementById('root')
);
