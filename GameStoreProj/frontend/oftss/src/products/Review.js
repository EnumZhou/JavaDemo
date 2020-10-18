import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Grid from '@material-ui/core/Grid';

// const products = [
//     { name: 'Product 1', desc: 'A nice thing', price: '$9.99' },
//     { name: 'Product 2', desc: 'Another thing', price: '$3.45' },
//     { name: 'Product 3', desc: 'Something else', price: '$6.51' },
//     { name: 'Product 4', desc: 'Best thing of all', price: '$14.11' },
//     { name: 'Shipping', desc: '', price: 'Free' },
// ];
// const addresses = ['1 Material-UI Drive', 'Reactville', 'Anytown', '99999', 'USA'];
// const payments = [
//     { name: 'Card type', detail: 'Visa' },
//     { name: 'Card holder', detail: 'Mr John Smith' },
//     { name: 'Card number', detail: 'xxxx-xxxx-xxxx-1234' },
//     { name: 'Expiry date', detail: '04/2024' },
// ];

const useStyles = makeStyles((theme) => ({
    listItem: {
        padding: theme.spacing(1, 0),
    },
    total: {
        fontWeight: 700,
    },
    title: {
        marginTop: theme.spacing(2),
    },
}));


export const Review =() => {
    const classes = useStyles();

    // const [products,setProducts] = React.useState([]);
    // const [addresses,setAddresses] = React.useState([]);
    // const [payments,setPayments] = React.useState([]);

    const cart=JSON.parse(localStorage.getItem("cart"));
    const ud=JSON.parse(localStorage.getItem("ud"));
    const products=cart;
    const payments=[];


    const addresses=[ud.address1,ud.address2,ud.city,ud.state,ud.zip,'US'];
    const getTotal=() => {
        let total=0;
        products.forEach(p => {
                total +=p.price*p.count;
            }
        )

        return total.toFixed(2);
    }

    //setAddresses(arrAddress);
    // console.log(cart);


    return (
        <React.Fragment>
            <Typography variant="h6" gutterBottom>
                Order summary
            </Typography>
            <List disablePadding>
                {products.map((product) => (
                    <ListItem className={classes.listItem} key={product.name}>
                        <ListItemText primary={`Item: ${product.name}`} secondary={`QTY: ${product.count}`} />
                        <Typography variant="body2">{product.price}</Typography>
                    </ListItem>
                ))}
                <ListItem className={classes.listItem}>
                    <ListItemText primary="Total" />
                    <Typography variant="subtitle1" className={classes.total}>
                        {getTotal()}
                    </Typography>
                </ListItem>
            </List>
            <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                    <Typography variant="h6" gutterBottom className={classes.title}>
                        Shipping
                    </Typography>
                    <Typography gutterBottom>{ud.name}</Typography>
                    <Typography gutterBottom>{addresses.join(', ')}</Typography>
                </Grid>
                <Grid item container direction="column" xs={12} sm={6}>
                    <Typography variant="h6" gutterBottom className={classes.title}>
                        Payment details
                    </Typography>
                    <Grid container>
                        {payments.map((payment) => (
                            <React.Fragment key={payment.name}>
                                <Grid item xs={6}>
                                    <Typography gutterBottom>{payment.name}</Typography>
                                </Grid>
                                <Grid item xs={6}>
                                    <Typography gutterBottom>{payment.detail}</Typography>
                                </Grid>
                            </React.Fragment>
                        ))}
                    </Grid>
                </Grid>
            </Grid>
        </React.Fragment>
    );
}
