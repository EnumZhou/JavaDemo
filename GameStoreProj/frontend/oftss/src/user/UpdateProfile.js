import React, {useState} from "react";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import TextField from "@material-ui/core/TextField";
import {updateUserDetail} from "../actions/auth.action";
import {appConstants} from "../constants/constants";
import {Link} from "react-router-dom";
const UpdateProfile= () => {


    const [userDetail,setUserDetail] = useState(JSON.parse(localStorage.ud));
    const [change,setChange]=useState(false);
    const handleSave = (event) => {
        event.preventDefault();
        //this.event.name = event.target.value
        updateUserDetail(userDetail);
        console.log(userDetail);
        localStorage.setItem('ud',JSON.stringify(userDetail));
    }


    const handleFormControl = (event) => {
        let newUserDetail={...userDetail};
        newUserDetail[event.target.id] = event.target.value;
        setUserDetail(newUserDetail);
        setChange(true);
    }

    return (
        <div>
            <p>Update userProfile</p>
            {/*{JSON.stringify(userDetail)}*/}
            <div>
                <React.Fragment>
                    <Typography variant="h6" gutterBottom>
                        Shipping address
                    </Typography>
                    <form onSubmit={handleSave}>
                        <Grid container spacing={3}>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    required
                                    id="name"
                                    name="name"
                                    label="Name"
                                    fullWidth
                                    value = {userDetail.name}
                                    onChange={handleFormControl}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    id="address1"
                                    name="address1"
                                    label="address line 1"
                                    fullWidth
                                    value = {userDetail.address1}
                                    onChange={handleFormControl}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    id="address2"
                                    name="address2"
                                    label="Address line 2"
                                    value = {userDetail.address2}
                                    onChange={handleFormControl}
                                    fullWidth
                                    autoComplete="billing address-line2"
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
                                    onChange={handleFormControl}
                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    id="state"
                                    name="state"
                                    label="State/Province/Region"
                                    fullWidth
                                    value = {userDetail.state}
                                    onChange={handleFormControl}
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
                                    onChange={handleFormControl}
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
                        </Grid>
                        <button
                            disabled={!change}
                        >Save</button>

                    </form>
                </React.Fragment>
            </div>
        </div>

    )
}

export default UpdateProfile;
