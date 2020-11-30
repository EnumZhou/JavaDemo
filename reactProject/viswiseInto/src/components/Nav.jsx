import React from "react";
import {NavLink} from "react-router-dom";

export const Nav = () => {
    return (
        <nav id="menu" className="navbar navbar-default navbar-fixed-top">
            <div className="container">
                <div className="navbar-header">
                    <button
                        type="button"
                        className="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"
                    >
                        {" "}
                        <span className="sr-only">Toggle navigation</span>{" "}
                        <span className="icon-bar"></span>{" "}
                        <span className="icon-bar"></span>{" "}
                        <span className="icon-bar"></span>{" "}
                    </button>
                    <a className="navbar-brand page-scroll" href="#page-top">
                        Viswise
                    </a>{" "}
                </div>

                <div
                    className="collapse navbar-collapse"
                    id="bs-example-navbar-collapse-1"
                >
                    <ul className="nav navbar-nav navbar-right">

                        <li>
                            <NavLink to="/about" >
                                About
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to="/courses">
                                Courses
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/testimonials">
                                Testimonials
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/team">
                                Team
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/contact" className="page-scroll">
                                Contact
                            </NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}
