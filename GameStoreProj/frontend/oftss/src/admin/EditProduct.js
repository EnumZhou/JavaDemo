import React,{Component} from "react";
import {Paper} from "@material-ui/core";
import {Field, Form, Formik} from "formik";
import Button from "@material-ui/core/Button";
import InputAdornment from "@material-ui/core/InputAdornment";
import {connect} from "react-redux";
import {editProduct, getProducts} from "../actions/products.action";
import TextField from "@material-ui/core/TextField";
import * as Yup from 'yup';
import './EditProduct.scss'
import {appConstants} from "../constants/constants";

const EditProductSchema = Yup.object().shape({
    name: Yup.string()
        .required('Product name is required'),
    category: Yup.string()
        .required('Product category is required'),
    platform:Yup.string()
        .required('Product platform is required'),
    price: Yup.number()
        .min(0, 'Product price has to be positive')
        .required('Product price is required'),
    stock: Yup.number()
        .min(0, 'Product stock has to be positive')
        .required('Product stock is required'),
    image: Yup.string()
        .required('Product image is required')
});


class EditProduct extends Component{

    componentDidMount() {
        !this.props.product && this.props.getProducts();
    }

    constructor(props) {
        super(props);
        this.state ={};
        // crating a React Ref to access DOM
        this.ref = React.createRef();
    }

    handleSubmit = () => {
        // we don't have event.preventDefault because formik took care of it
        // similar to angular ElementRef which wraps native html element in
        // {native: htmlNativeElement}
        this.ref.current.classList.add('submitted');

    }

    // field: {name: "name", value: undefined, onChange: ƒ, onBlur: ƒ}
    // form: {values: undefined, errors: {…}, touched: {…}, status: undefined, isSubmitting: false, …}
    // type: "text"
    // label: "Name"
    // children: undefined

    static renderField ({field, form: {errors, touched}, ...props}) {
        //console.log(props);
        return (
            <TextField
                className="form-control"
                // field: {name: "name", value: undefined, onChange: ƒ, onBlur: ƒ}
                {...field}
                {...props}
                // 用来给textField里的price加一个$
                InputProps={{
                    startAdornment:
                        field.name === 'price' && <InputAdornment position="start">$</InputAdornment>
                }}
                error={errors[field.name] && touched[field.name]}
                helperText={errors[field.name]}
            />
        );

    }



    handleDone = (event) => {
        event.preventDefault();
        //this.event.name = event.target.value

        editProduct(this.state);
    }


    handleFormControl = (event) => {
        // synthetic event interview question **********
        //const newState = {...this.state};
        let newState=this.props.product;
        newState[event.target.name] = event.target.value;
        this.setState(newState);
    }

    render() {
        return (
            this.props.product &&
            <Paper elevation={3} className="EditProduct" ref = {this.ref}>
                <h2>Edit Product</h2>
                <Formik
                    initialValues={this.props.product}
                    onSubmit={this.handleSubmit}
                    validationSchema={EditProductSchema}
                >
                    {
                        ( ) => (
                            <Form className='form-group' onSubmit= {this.handleDone}>
                                {
                                    appConstants.product_field.map(field => (
                                        <Field
                                            key = {field.displayName}
                                            name = {field.name}
                                            type = {field.type}
                                            label = {field.displayName}
                                            component ={EditProduct.renderField}
                                            onChange={this.handleFormControl}
                                        />
                                        )

                                    )
                                }

                                <Button type="submit" color="primary">Done</Button>
                            </Form>
                        )
                    }
                </Formik>
            </Paper>
        );
    }

}

/* localhost:8080/edit-product/1 */
function mapStateToProps({products},ownProps /*component props */) {
    if(products) {
        const id = +ownProps.match.params.id; // get product id from url
        const product = products.find(e => e.id === id);
        return {product};
    } else {
        return {product: null}
    }

}

// mapStateToProps get the specify product from react-redux state
// {getProducts} store the products into react-redux
export default connect(mapStateToProps, {getProducts}) (EditProduct);
