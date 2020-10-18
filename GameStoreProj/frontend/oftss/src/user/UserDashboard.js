import React, { useState} from "react";

import { Link } from "react-router-dom";


import Layout from "../components/Layout";
import {getUserByUsername} from "../actions/auth.action";
import {useDispatch} from "react-redux";
import {appConstants} from "../constants/constants";
import {PurchaseHistory} from "./PurchaseHistory";

const Dashboard = () => {
    // const t = true;
    const [history, setHistory] = useState([]);

    let userDetail ={};

    const [user,setUser] = useState({
        user:{},
        error:false,
        success:true,
    });
    const dispatch=useDispatch();


    const getUser = () => {
        let user = JSON.stringify(localStorage.user);
        // console.log(user);
        let userna= JSON.parse(user);
        // console.log(userna);
        // console.log(JSON.parse(userna));
        let username = JSON.parse(userna).username;
        // console.log(username);
        return username;
    }

    const username = getUser();
    // console.log(username)
    const newVal= dispatch(getUserByUsername(username));
    newVal.then(res => {
        // console.log(res.payload.success);
        if(user.success){
            //console.log('res.success: ',res.payload.user);
            userDetail=res.payload.user;
            //console.log(userDetail);
            setUser({user:res.payload.user,error:false,success:false})
        }
        else {
            // console.log(res);
            // console.log('res.success',res.payload.success);
            // console.log(res.payload.message)
        }
    })
    localStorage.setItem('user',JSON.stringify(user.user));



    const userLinks = () => {
        return (
            <div className="card">
                <h4 className="card-header">User Links</h4>
                <ul className="list-group">
                    <li className="list-group-item">
                        <Link className="nav-link" to={appConstants.cartRoute}>
                            My Cart
                        </Link>
                    </li>
                    <li className="list-group-item">
                        <Link to={appConstants.updateProfileRoute} className="nav-link" >
                            Update Profile
                        </Link>
                    </li>
                </ul>
            </div>
        );
    };

    const userInfo = () => {
        const userInfo = JSON.parse(localStorage.ud);
        //console.log(userInfo)
        return (
            <div className="card mb-5">
                <h3 className="card-header">User Information</h3>
                <ul className="list-group">
                    {/*{JSON.stringify(user)}*/}
                    <li className="list-group-item">Name: {userInfo.name}</li>
                    <li className="list-group-item">Email: {userInfo.email}</li>
                    <li className="list-group-item">Address1: {userInfo.address1}</li>
                    <li className="list-group-item">Address2: {userInfo.address2}</li>
                    <li className="list-group-item">City: {userInfo.city}</li>
                    <li className="list-group-item">State: {userInfo.state}</li>
                    <li className="list-group-item">Zip: {userInfo.zip}</li>
                </ul>
                <Link to={appConstants.updateProfileRoute}>
                    <button >Modify</button>
                </Link>

            </div>
        );
    };

    // const purchaseHistory = history => {
    //     return (
    //         <div className="card mb-5">
    //             <h3 className="card-header">Purchase history</h3>
    //             <ul className="list-group">
    //                 <li className="list-group-item">
    //                     {history.map((h, i) => {
    //                         return (
    //                             <div>
    //                                 <hr />
    //                                 {h.products.map((p, i) => {
    //                                     return (
    //                                         <div key={i}>
    //                                             <h6>Product name: {p.name}</h6>
    //                                             <h6>
    //                                                 Product price: ${p.price}
    //                                             </h6>
    //                                             <h6>
    //                                                 Purchased date:{" "}
    //                                             </h6>
    //                                         </div>
    //                                     );
    //                                 })}
    //                             </div>
    //                         );
    //                     })}
    //                 </li>
    //             </ul>
    //         </div>
    //     );
    // };

    const userDe = JSON.parse(localStorage.ud);
    return (
        <Layout
            title="Dashboard"
            description={`Hello, ${userDe.name}`}
            className="container-fluid"
        >
            <div className="row">
                <div className="col-3">{userLinks()}</div>
                <div className="col-9">
                    {userInfo()}

                    <PurchaseHistory/>
                </div>
            </div>
        </Layout>
    );
};

export default Dashboard;
