import {useSelector} from "react-redux";
import {useEffect} from "react";
import {appConstants} from "../constants/constants";
import React from "react";

export const AuthGuard = (ExistingComponent) => {
    const HOCComponent =(props) => {
        console.log(props.history);
        const user = useSelector(state => state.user);


        useEffect(() =>{
            console.log(user);
            !user && props.history.push(appConstants.loginRoute);

            return () =>
            {
                console.log('component unmounted');
            };
        });


        return (
            <ExistingComponent {...props}/>
        )

    };

    return HOCComponent;
}
