import React from "react";
import { MDBCol, MDBContainer, MDBRow, MDBFooter } from "mdbreact";


const FooterPage = () => {
    return (
        <MDBFooter style={{
            backgroundColor : "#e6e2c3"
        }} className="font-small pt-4 mt-4">
            <MDBContainer fluid className="text-center text-md-left">
                <MDBRow>
                    <MDBCol md="6">
                        <h5 className="title">VIDEO GAMES</h5>
                        <p>
                            ENJOY LIFE AND ENJOY GAME
                        </p>
                    </MDBCol>
                    <MDBCol md="6">
                        <h5 className="title">Find It</h5>
                        <ul>
                            <li className="list-unstyled">
                                <a href="#!">Digital Games</a>
                            </li>
                            <li className="list-unstyled">
                                <a href="#!">Order History</a>
                            </li>
                            <li className="list-unstyled">
                                <a href="#!">Game Informer</a>
                            </li>
                            <li className="list-unstyled">
                                <a href="#!">GameStop International</a>
                            </li>
                        </ul>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
            <div className="footer-copyright text-center py-3">
                <MDBContainer fluid>
                    &copy; {new Date().getFullYear()} Copyright: <a href="https://www.mdbootstrap.com"> MDBootstrap.com </a>
                </MDBContainer>
            </div>
        </MDBFooter>
    );
}

export default FooterPage;
