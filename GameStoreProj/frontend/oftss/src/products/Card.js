import React, {useState} from "react";
import {Redirect} from "react-router-dom";
import {removeItem, updateItem} from "./cartHelper";


const Card = ({
                  product,

                  showAddToCartButton = true,
                  cartUpdate = false,
                  showRemoveProductButton = false
              }) => {
    const [redirect, setRedirect] = useState(false);
    const [count, setCount] = useState(product.count);


    const shouldRedirect = redirect => {
        if (redirect) {
            return <Redirect to="/cart"/>;
        }
    };


    const showRemoveButton = (showRemoveProductButton) => {
        return (
            showRemoveProductButton && (
                <button
                    onClick={() => removeItem(product._id)}
                    className="btn btn-outline-danger mt-2 mb-2"

                >
                    Remove Product
                </button>
            )
        );
    };

    const showStock = quantity => {
        return quantity > 0 ? (
            <span className="badge badge-primary badge-pill">In Stock</span>
        ) : (
            <span className="badge badge-primary badge-pill">Out of Stock</span>
        );
    };

    const handleChange = productId => event => {
        //console.log(productId)
        setCount(event.target.value < 1 ? 1 : event.target.value);
        if (event.target.value >= 1) {
            updateItem(productId, event.target.value);
            let cart = JSON.parse(localStorage.getItem("cart"));
            //const updatedProduct=cart.find(ele => ele.id === productId)
            for (let c of cart) {
                if (c.id === productId) {
                    c.count = event.target.value;
                }
            }
            localStorage.setItem('cart', JSON.stringify(cart));
        }
    };

    const showCartUpdateOptions = cartUpdate => {
        return (
            cartUpdate && (
                <div>
                    <div className="input-group mb-3">
                        <div className="input-group-prepend">
                            <span className="input-group-text">
                                Adjust Quantity
                            </span>
                        </div>
                        <input
                            type="number"
                            className="form-control"
                            value={count}
                            onChange={handleChange(product.id)}
                        />
                    </div>
                </div>
            )
        );
    };

    return (
        <div className="card">
            <div className="card-header name">{product.name}</div>
            <div className="card-body">


                <p className="black-10">${product.price}</p>
                <p className="black-9">
                    Category: {product.category}
                </p>
                <p className="black-9">
                    Platform: {product.platform}
                </p>
                {showStock(product.stock)}
                <br/>
                {showRemoveButton(showRemoveProductButton)}
                {showCartUpdateOptions(cartUpdate)}
            </div>
        </div>
    );
};

export default Card;
