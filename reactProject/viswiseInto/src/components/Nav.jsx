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
                            <NavLink to="/home" >
                                Home
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to="/courses">
                                About
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/services">
                                Services
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/programs">
                                Programs
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/community">
                                Community
                            </NavLink>
                        </li>

                        <li>
                            <NavLink to="/blog">
                                Blog
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
