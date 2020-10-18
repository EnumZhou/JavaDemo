import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

const Layout = ({
                    title='',
                    description="",
                    classname,
                    children}) => (
    <div>
        <div className="jumbotron">
            <h2 className="text-center">{title}</h2>
            <p className="lead">{description}</p>
        </div>
        <div className={classname}>{children}</div>
    </div>

)
export default Layout;
