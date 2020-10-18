import React from "react";


export const showError = (obj) => {
    return (
        <div
            className="alert alert-danger"
            style={{display:obj.error?'' : 'none'}}
        >
            {obj.message}
        </div>
    );
}

export const showSuccess=(obj) => {
    return(
        <div
            className="alert alert-info"
            style={{display:obj.success?'': 'none'}}
        >
            {obj.message}
        </div>
    );
}
