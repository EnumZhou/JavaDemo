import axios from "axios";
import {appConstants} from "../constants/constants";

export const placeOrder=(order) =>{
    const  placeOrderPromise = axios.post(`${process.env.REACT_APP_API_URL}/orders`,order)
    .then (res => {
        console.log(res);
        if(res) {
            return {
                success:true,
                order:res.data
            }
        }
        return {
            success:false,
            order:null
        }
    })
    return {
        type: appConstants.PLACE_ORDER,
        payload: placeOrderPromise,
    };
}

export const getOrderByUserId = (userId) => {
    const getOrderByUserIdPromise =axios.get(`${process.env.REACT_APP_API_URL}/orders/userId/${userId}`)
        .then (res => {
            //console.log(res);
            if(res) {
                console.log(res);
                const needed=[];
                res.data.forEach(e => {
                    // console.log(e.purchases);
                    // console.log(e.purchaseDate);
                    const obj={
                        "order_id": e.id,
                        "purchase_date":e.purchaseDate,
                        "purchases": e.purchases,
                    }
                    needed.push(obj);
                });
                console.log(needed);
                return {
                    success:true,
                    orders:needed,
                }
            }
            return {
                success:true,
                orders:null,
            }

        }).catch(err => {
            return {
                success:true,
                orders:null,
            }
        })

    return {
        type:appConstants.GET_ORDER_BY_USERID,
        payload: getOrderByUserIdPromise,
    };
}

export const getAllOrders = () => {
    const getAllOrdersPromise =axios.get(`${process.env.REACT_APP_API_URL}/orders`)
        .then ( res => {
            console.log(res);
            if(res) {
                console.log(res);
                const needed=[];
                res.data.forEach(e => {
                    // console.log(e.purchases);
                    // console.log(e.purchaseDate);
                    const obj={
                        "order_id" : e.id,
                        "purchase_date":e.purchaseDate,
                        "purchases": e.purchases,
                    }
                    needed.push(obj);
                });
                console.log(needed);
                return {
                    success:true,
                    orders:needed,
                }
            }
            return {
                success:true,
                orders:null,
            }

        }).catch(err => {
            return {
                success:true,
                orders:null,
            }
        })

    return {
        type:appConstants.GET_ORDER_BY_USERID,
        payload: getAllOrdersPromise,
    };

}

export const deleteOrderById = (id) => {
    const deleteOrderByIdPromise=axios.delete(`${process.env.REACT_APP_API_URL}/orders/${id}`)
        .then (res => {
                console.log(res);
                if(res.success) {
                    return {
                        deleted: true,
                    }
                }

                return {
                    deleted:false,
                }
        })
        .catch(err => {
            return {
                deleted:false,
            }
        })

    return {
        type:appConstants.GET_ORDER_BY_USERID,
        payload: deleteOrderByIdPromise,
    };
}
