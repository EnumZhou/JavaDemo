import React, {Component, Fragment} from "react";
import MyDocument from "../component/MyDocument";

export class App extends Component {
    render() {
        return (
            <Fragment>
                <main>
                    <MyDocument />
                    {this.props.children}
                </main>
            </Fragment>
        );
    }
}
