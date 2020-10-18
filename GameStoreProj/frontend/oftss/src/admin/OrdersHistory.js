import React, {useState} from "react";
import {useDispatch} from "react-redux";
import {deleteOrderById, getAllOrders} from "../actions/order.action";
import 'bootstrap/dist/css/bootstrap.min.css';
import {showSuccess} from "../components/Alert";

export const OrdersHistory =() => {

    const [history,setHistory] = useState({
            purchases:[],
            error: false,
            success:true,
            delete: false,
        }
    );
    const dispatch=useDispatch();


    // const userId=JSON.parse(localStorage.getItem("ud")).id;
    //console.log(userId);
    const historyPromise=dispatch(getAllOrders());
    historyPromise.then(res => {
        //console.log(res);
        if(history.success){
            //console.log(res.payload.orders)
            setHistory({...history,purchases:res.payload.orders,success: false});
            // console.log(history)
        }

    });

    const handleDelete =(e) => {
        //console.log(e.target.value)
        setHistory({...history,success:true,delete:true});
        deleteOrderById(e.target.value);
    }



    const orderHistory = history => {
        return (
            <div className="card mb-5">
                <h3 className="card-header">Orders history</h3>
                {showSuccess({
                    success:history.delete,
                    message: "Deleted Successfully",
                })}
                <ul className="list-group">
                    <li className="list-group-item">
                        {history.purchases.map((h, i) => {
                            console.log(h.order_id)
                            return (
                                <div key={i}>
                                    <h6>Order Id: {h.order_id}</h6>
                                    {h.purchases.map((p, i) => {
                                        return (
                                            <div key={i}>

                                                <h6>Item name: {p.product.name}</h6>
                                                <h6>
                                                    Item price: ${p.product.price}
                                                </h6>
                                                <h6>
                                                    Purchased date: {h.purchase_date}
                                                </h6>

                                            </div>
                                        );
                                    })}
                                    <button
                                        value = {h.order_id}
                                        onClick={(event) => handleDelete(event)}>Delete</button>
                                    <hr />
                                </div>

                            );
                        })}
                    </li>
                </ul>
            </div>
        );
    };

    return (
        <div>
            {orderHistory(history)}
        </div>
    );
}
