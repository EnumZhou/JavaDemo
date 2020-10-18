import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Paper from '@material-ui/core/Paper';
import Stepper from '@material-ui/core/Stepper';
import Step from '@material-ui/core/Step';
import StepLabel from '@material-ui/core/StepLabel';
import Button from '@material-ui/core/Button';
import Link from '@material-ui/core/Link';
import Typography from '@material-ui/core/Typography';
import AddressForm from './AddressForm';
import PaymentForm from './PaymentForm';
import {Review} from "./Review";
import {placeOrder} from "../actions/order.action";
import {editProduct} from "../actions/products.action";



function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://material-ui.com/">
                Your Website
            </Link>{' '}
            {new Date().toLocaleString()}
            {'.'}
        </Typography>
    );
}

const useStyles = makeStyles((theme) => ({
    appBar: {
        position: 'relative',
    },
    layout: {
        width: 'auto',
        marginLeft: theme.spacing(2),
        marginRight: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(2) * 2)]: {
            width: 600,
            marginLeft: 'auto',
            marginRight: 'auto',
        },
    },
    paper: {
        marginTop: theme.spacing(3),
        marginBottom: theme.spacing(3),
        padding: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(3) * 2)]: {
            marginTop: theme.spacing(6),
            marginBottom: theme.spacing(6),
            padding: theme.spacing(3),
        },
    },
    stepper: {
        padding: theme.spacing(3, 0, 5),
    },
    buttons: {
        display: 'flex',
        justifyContent: 'flex-end',
    },
    button: {
        marginTop: theme.spacing(3),
        marginLeft: theme.spacing(1),
    },
}));

const steps = ['Shipping address', 'Payment details', 'Review your order'];

function getStepContent(step) {
    switch (step) {
        case 0:
            return <AddressForm />;
        case 1:
            return <PaymentForm />;
        case 2:
            return <Review />;
        default:
            throw new Error('Unknown step');
    }
}

export default function Checkout() {
    const classes = useStyles();
    const [activeStep, setActiveStep] = React.useState(0);

    const handleNext = () => {
        setActiveStep(activeStep + 1);
        if(activeStep===2) {
            handleSubmit();
        }
        updateStock();
    };

    const handleBack = () => {
        setActiveStep(activeStep - 1);
    };

    //format orders
    const formatOrder =() => {
        const purchase=[];
        const cart=JSON.parse(localStorage.getItem("cart"));
        //console.log(cart)
        const product = {
            qty: 0,
            product: {
                id : 0
            }
        }
        cart.forEach(c => {
            //console.log(c)
            product.qty = c.count;
            product.product.id = c.id;
            purchase.push(product);
        });
        const userDetail=JSON.parse(localStorage.getItem("ud"));


        const order= {
            purchase_date: new Date().toLocaleString(),
            user: {
                id: userDetail.id
            },
            purchases: []
        }
        order.purchases = purchase;
        //console.log(order);
        return order;
    }

    const getPurchases =()=> {
        const purchases=[];
        const cart=JSON.parse(localStorage.getItem("cart"));
        const product = {
            id: 0,
            name:'',
            category:'',
            price:'',
            stock:'',
            platform:'',
            image:'',
        }
        cart.forEach(
            c => {
                product.id=c.id;
                product.name=c.name;
                product.category=c.category;
                product.price=c.price;
                product.stock=c.stock-c.count;
                product.platform=c.platform;
                product.image=c.image;
                purchases.push(product)
            }
        )
        return purchases;
    }

    //update stock
     const updateStock =()=> {
        const purchases=getPurchases();
        purchases.forEach(p => {
            editProduct(p);
        })
     }





    // submit an order
    const handleSubmit = ()=> {
            const order=formatOrder();
            placeOrder(order);
            localStorage.setItem("cart",[]);
    }


    return (
        <React.Fragment>
            <CssBaseline />
            <AppBar position="absolute" color="default" className={classes.appBar}>
                <Toolbar>
                    <Typography variant="h6" color="inherit" noWrap>
                        Game Store
                    </Typography>
                </Toolbar>
            </AppBar>
            <main className={classes.layout}>
                <Paper className={classes.paper}>
                    <Typography component="h1" variant="h4" align="center">
                        Checkout
                    </Typography>
                    <Stepper activeStep={activeStep} className={classes.stepper}>
                        {steps.map((label) => (
                            <Step key={label}>
                                <StepLabel>{label}</StepLabel>
                            </Step>
                        ))}
                    </Stepper>
                    <React.Fragment>
                        {activeStep === steps.length ? (
                            <React.Fragment>
                                <Typography variant="h5" gutterBottom>
                                    Thank you for your order.
                                </Typography>
                                <Typography variant="subtitle1">
                                    We have emailed your order confirmation, and will
                                    send you an update when your order has shipped.
                                </Typography>
                            </React.Fragment>
                        ) : (
                            <React.Fragment>
                                {getStepContent(activeStep)}
                                <div className={classes.buttons}>
                                    {activeStep !== 0 && (
                                        <Button onClick={handleBack} className={classes.button}>
                                            Back
                                        </Button>
                                    )}
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        onClick={handleNext}
                                        className={classes.button}
                                    >
                                        {activeStep === steps.length - 1 ? 'Place order' : 'Next'}

                                    </Button>
                                    {/*<Button*/}
                                    {/*    onClick={handleSubmit}>*/}
                                    {/*    {activeStep === 2? 'Place order': null  }*/}
                                    {/*</Button>*/}
                                </div>
                            </React.Fragment>
                        )}
                    </React.Fragment>
                </Paper>
                <Copyright />
            </main>
        </React.Fragment>
    );
}
