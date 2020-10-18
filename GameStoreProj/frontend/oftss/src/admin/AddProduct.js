import React, {Component} from "react";

import classes from "./AddProduct.module.scss"
import TextField from "@material-ui/core/TextField";
import {appConstants} from "../constants/constants";
import {connect} from "react-redux";
import {addProduct} from "../actions/products.action";

class AddProduct extends Component {

    constructor(props) {
        super(props);

        const state = {
            product: {},
            form: {},
            error: {}
        }

        appConstants.product_field.forEach(field => {
            state.product[field.name] ='';
            state.form[field.name] = {
                dirty:false, //你有没有碰到那个textField
                touched:false //你有没有input什么东西
            };

            state.error[field.name] = `${field.displayName} is required.`;
        });
        this.state = state;
    }



    handleSubmit = (event) => {
        event.preventDefault();
        this.props.addProduct(this.state.product);
    }

    handleFormControl = (event) => {
        // synthetic event interview question **********
        const newState = {...this.state};

        newState.product[event.target.id] = event.target.value;
        //validation
        newState.form[event.target.id].touched = true;
        newState.form[event.target.id].dirty = true;
        event.target.value === '' ?
            newState.error[event.target.id] = `${event.target.name} is required` :
            delete newState.error[event.target.id];

        this.setState(newState);
    }

    handleBlur = (event) => {
        const newState = {...this.state};
        newState.form[event.target.id].touched =true;
        this.setState(newState);
    }

    // form states: valid, pristine/dirty, touched
    renderControl =(field) => (
        <TextField
            name={field.displayName}
            key={field.name}
            id={field.name}
            label={field.displayName}
            margin="normal"
            variant="outlined"
            type={field.type}
            error={this.state.form[field.name].touched && !!this.state.error[field.name]}
            helperText={this.state.form[field.name].touched && this.state.error[field.name]}
            onBlur={this.handleBlur}
            onChange={this.handleFormControl}
            value={this.state.product[field.name]}
        />
    );



    render() {
        return(
            <form className={classes.AddProduct} onSubmit={this.handleSubmit}>
                <h2 className={classes.header}>Add Product</h2>

                {
                    // renderControl returns a jsx
                    appConstants.product_field.map(field => this.renderControl(field))
                }

                <button className={classes.addProductButton} disabled={Object.keys(this.state.error).length}>
                    {/*<AddIcon className={classes.addProductIcon}/>*/}
                    <span > Add Product</span>
                </button>
            </form>
        );
    }


}

export default connect(null, {addProduct})(AddProduct);
