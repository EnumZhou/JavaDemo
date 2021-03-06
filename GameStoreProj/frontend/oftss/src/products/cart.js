import React, {useState, useEffect, useLayoutEffect} from "react";
import { Link } from "react-router-dom";


import Layout from "../components/Layout";
import {getCart} from "./cartHelper";
import {appConstants} from "../constants/constants";
import Card from "./Card";
import 'bootstrap/dist/css/bootstrap.min.css';
import Checkout from "./Checkout";




const Cart = () => {
    const [items, setItems] = useState(getCart());


    const showItems = items => {
        return (
            <div>
                <h2>Your cart has {`${items.length}`} items</h2>
                <hr />
                {items.map((product, i) => (
                    <Card
                        key={i}
                        product={product}
                        showAddToCartButton={false}
                        cartUpdate={true}
                        showRemoveProductButton={true}
                    />
                ))}
            </div>
        );
    };


    const noItemsMessage = () => (
        <h2>
            Your cart is empty. <br />
            <Link to={appConstants.videoGamesRoute}>
            <button className="btn btn-primary">Go Shopping</button>
            </Link>
        </h2>
    );

    return (
        <Layout
            title="Shopping Cart"
            description="Manage your cart items. Add remove checkout or continue shopping."
            className="container-fluid"
        >
            <div className="row">
                <div className="col-6">
                    {items.length > 0 ? showItems(items) : noItemsMessage()}
                </div>

                <div className="col-6">
                    <h2 className="mb-4">Your cart summary</h2>
                    <hr />
                    <Checkout products={items} />
                </div>
            </div>
        </Layout>
    );
};

export default Cart;
