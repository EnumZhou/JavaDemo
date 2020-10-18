import React, {useState} from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';


export default function AddressForm() {

    let userDetail = JSON.parse(localStorage.ud);

    const handleChange= name => event => {
        //setUserDetail({...userDetail,[name]:event.target.value});
        userDetail={...userDetail,[name]:event.target.value};
    };

    return (
        <React.Fragment>
            <Typography variant="h6" gutterBottom>
                Shipping address
            </Typography>
            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <TextField
                        required
                        id="name"
                        name="name"
                        label="Name"
                        fullWidth
                        value = {userDetail.name}
                        onChange={handleChange()}
                        // autoComplete="fname"
                    />
                </Grid>
                <Grid item xs={12}>
                    <TextField
                        required
                        id="address1"
                        name="address1"
                        label="Address line 1"
                        fullWidth
                        value = {userDetail.address1}
                        onChange={handleChange}
                    />
                </Grid>
                <Grid item xs={12}>
                    <TextField
                        id="address2"
                        name="address2"
                        label="Address line 2"
                        fullWidth
                        autoComplete="billing address-line2"
                        value = {userDetail.address2}
                        onChange={handleChange}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="city"
                        name="city"
                        label="City"
                        fullWidth
                        autoComplete="billing address-level2"
                        value = {userDetail.city}
                        onChange={handleChange}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        id="state"
                        name="state"
                        label="State/Province/Region"
                        fullWidth
                        value = {userDetail.state}
                        onChange={handleChange}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="zip"
                        name="zip"
                        label="Zip / Postal code"
                        fullWidth
                        autoComplete="billing postal-code"
                        value = {userDetail.zip}
                        onChange={handleChange}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="country"
                        name="country"
                        label="Country"
                        fullWidth
                        autoComplete="billing country"
                        value = "US"
                    />
                </Grid>
                {/*<Grid item xs={12}>*/}
                {/*    <FormControlLabel*/}
                {/*        control={<Checkbox color="secondary" name="saveAddress" value="yes" />}*/}
                {/*        label="Use this address for payment details"*/}
                {/*    />*/}
                {/*</Grid>*/}
            </Grid>
        </React.Fragment>
    );
}
