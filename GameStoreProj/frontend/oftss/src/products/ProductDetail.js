import React, {useState} from "react";
import {read} from "./getProductByid";
import {addItem} from "./cartHelper";
import 'bootstrap/dist/css/bootstrap.min.css';
import Image from 'react-bootstrap/Image'
import Col from "react-bootstrap/Col";

const ProductDetail = props =>{
    useState(() => {
        const Id = props.match.params.id;
        const handleSubmit = (Id) => {


            read(Id).then(res => {
                setProduct(res);
            })
        }
        handleSubmit(Id);

    })
    const [product,setProduct] = useState({});


    const addToCart = () => {
        addItem(product,() => {})
    }


    return (
        <div className="card">
            <div className="card-header name">{product.name}</div>
            <Col xs={6} md={4}>
                <Image src={product.image} roundedCircle />
            </Col>
            {/*<img class="card-img-top" src={product.image}></img>*/}
            <div className="card-body">
                <p className="card-text">name:{product.name}</p>
                <p className="card-text">category:{product.category}</p>
                <p className="card-text"> platform:{product.platform}</p>
                <p className="card-text">stock:{product.stock}</p>
                <p className="card-text"></p>
                <p>price:${product.price}</p >
                {/*<p className="black-9"></p >*/}
            </div>
            <button  className="btn btn-danger" onClick={addToCart}>Add To Cart</button>
        </div>
        )
}

export default ProductDetail;
