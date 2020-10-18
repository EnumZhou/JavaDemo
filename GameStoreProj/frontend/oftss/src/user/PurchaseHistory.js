import React, {useState} from 'react';

import {useDispatch} from "react-redux";
import {getOrderByUserId} from "../actions/order.action";

export const PurchaseHistory =() => {

    const [history,setHistory] = useState({
            purchases:[],
            error: false,
            success:true,
            cancel:false,
        }
    );
    const dispatch=useDispatch();


    const userId=JSON.parse(localStorage.getItem("ud")).id;
    //console.log(userId);
    const historyPromise=dispatch(getOrderByUserId(userId));
    historyPromise.then(res => {
        //console.log(res);
        if(history.success){
            console.log(res.payload.orders)
            setHistory({...history,purchases:res.payload.orders,success:false});
            //setId({...id,id:})
            // console.log(history)
        }
    });

    const handleCancel =(e) =>{
        console.log(e.target.value);
        setHistory({...history,cancel:true});

    }

    const handleProcess =(e)=> {
        console.log(e.target.value);
        setHistory({...history,cancel:false});

    }

    const renderButton = key => {
        console.log(key)
        return history.cancel?
            <button
                value={key}
                onClick={ (event) => {
                handleProcess(event)
            }}>Processing</button>
            :
            <button
                value={key}
                onClick={(event) => {
                handleCancel(event);
            }}>Cancel</button>
    }


    const purchaseHistory = history => {
        return (
            <div className="card mb-5">
                <h3 className="card-header">Purchase history</h3>
                <ul className="list-group">
                    <li className="list-group-item">
                        {history.purchases.map((h, i) => {
                            return (
                                <div key={i}>
                                    <hr />
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
                                    {renderButton(h.order_id)}
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
            {purchaseHistory(history)}
        </div>
    );
}
// import React, {useState} from "react";
// import {useDispatch} from "react-redux";
// import {getOrderByUserId} from "../actions/order.action";
// export const PurchaseHistory =() => {
//     // const [history,setHistory] = useState([]);
//     const dispatch=useDispatch();
//     let history=[];
//
//     const userId=JSON.parse(localStorage.getItem("ud")).id;
//     //console.log(userId);
//     const historyPromise=dispatch(getOrderByUserId(userId));
//     historyPromise.then(res => {
//         //console.log(res);
//         if(res.payload.success){
//             //console.log(res.payload.orders)
//             history =res.payload.orders;
//             history.forEach(
//                 innerArr => {
//                     //console.log(innerArr);
//                     innerArr.forEach(
//                         e=> {
//                             console.log(e)
//                         }
//                     )
//                 }
//             )
//             //console.log(history);
//         }
//     });
//
//
//     return (<div>hhhhhh</div>);
// }
