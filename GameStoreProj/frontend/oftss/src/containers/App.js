import React, {Component} from "react";
import Header from "../header/Header";
import FooterPage from "../components/Footer";

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <nav>
                    <Header/>
                </nav>
                <main className= "app-content">
                    {/*similar to router-outlet*/}
                    {this.props.children}
                    <FooterPage/>
                </main>

            </React.Fragment>
        );
    }

}

export default App;
