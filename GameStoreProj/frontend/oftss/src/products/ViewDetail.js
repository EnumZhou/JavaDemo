import { Link, Redirect } from "react-router-dom";

const showViewButton = showViewProductButton => {
    return (
        showViewProductButton && (
            <Link to={`/product/${product._id}`} className="mr-2">
                <button className="btn btn-outline-primary mt-2 mb-2">
                    View Product
                </button>
            </Link>
        )
    );
};

export default showViewButton()
