import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {Route, Switch} from "react-router";
import {appConstants} from "./constants/constants";
import App from "./containers/App";
import {BrowserRouter} from "react-router-dom";
import {Home} from "./home/Home.";
import Products from "./products/Products";
import {Provider} from "react-redux";
import {applyMiddleware, createStore} from "redux";
import reduxPromise from 'redux-promise'
import {rootReducer} from "./reducers/root.reducer";
import {Login} from "./auth/Login";
import Signup from "./auth/Signup";
import AddProduct from "./admin/AddProduct";
import ProductDetail from "./products/ProductDetail";
import Cart from "./products/cart";
import Dashboard from "./user/UserDashboard";
import Checkout1 from "./products/Checkout1";
import EditProduct from "./admin/EditProduct";
import UpdateProfile from "./user/UpdateProfile";
import AdminDashboard from "./admin/AdminDashboard";





ReactDOM.render(
    <Provider store={applyMiddleware(reduxPromise)(createStore)(rootReducer)}>
    <BrowserRouter>
    <App>
        <Switch> {/*Routes in Angular*/}
            <Route path={appConstants.loginRoute} component={Login}/>
            <Route path={appConstants.homeRoute} component={Home}/>
            <Route path={appConstants.addProductRoute} component={AddProduct} />
            <Route path={appConstants.videoGamesRoute} component={Products}/>

            <Route path={appConstants.registerRoute} component={Signup}/>
            <Route path="/product/:id" exact component={ProductDetail}/>

            <Route path={`${appConstants.editRoute}/:id`} component={EditProduct}/>

            <Route path={appConstants.userProfileRoute} exact component={Dashboard}/>
            <Route path={appConstants.cartRoute} exact component={Cart}/>
            <Route path="/checkout1" exact component={Checkout1}/>
            <Route path={appConstants.updateProfileRoute} exact component={UpdateProfile}/>
            <Route path={appConstants.adminDashboadRoute} component={AdminDashboard}/>


            {/*<Route path ="*">*/}
            {/*    <Redirect to={appConstant.homeRoute}/>*/}
            {/*</Route>*/}
        </Switch>
    </App>
    </BrowserRouter>
    </Provider>
    , document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
