import React from "react";
import {Nav} from "./Nav";

export const CustomizedApp = (props) => {
    return (
        <React.Fragment>
            <Nav />
            <main>
                {props.children}
            </main>
        </React.Fragment>
    );
}
