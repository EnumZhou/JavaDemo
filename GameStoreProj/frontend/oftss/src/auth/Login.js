import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {useDispatch} from "react-redux";
import {getUserByUsername, login} from "../actions/auth.action";
import InputAdornment from "@material-ui/core/InputAdornment";
import UsernameIcon from "@material-ui/icons/Person";
import PasswordIcon from "@material-ui/icons/VpnKey";
import {NavLink} from "react-router-dom";
import {appConstants} from "../constants/constants";
import {Redirect} from "react-router";

function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://material-ui.com/">
                Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}


const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));

export const Login = (props) => {


    const classes = useStyles();

    const dispatch = useDispatch();

    const [user, setUser] = React.useState(
        {
            username: '',
            password: '',
            error:false,
            success:false,
            message:'',
            redirectToHome:false
        }

    );

    const userDetail={};

    const handleFormControl = (event) => {
        const newUser = {...user};
        newUser[event.target.name] = event.target.value;
        setUser(newUser);
    }


    const handleLogin = (event) => {
        event.preventDefault()
        dispatch(login(
            user,
            // login success callback
            () =>{
                // console.log('Login successful');
                setUser({...user,redirectToHome:true});
                localStorage.setItem("user",JSON.stringify(user))
                //props.history.goBack();

                const username = user.username;
                console.log(username)
                const newVal= dispatch(getUserByUsername(username));
                newVal.then(res => {
                    // console.log(res.payload.success);
                    if(res.payload.success) {
                        console.log('res.success: ',res.payload.user);
                        localStorage.setItem('ud',JSON.stringify(res.payload.user.userDetail));
                        localStorage.setItem('Authority',JSON.stringify(res.payload.user.userProfile));
                    }
                    else {
                        // console.log(res);
                        // console.log('res.success',res.payload.success);
                        // console.log(res.payload.message)
                    }
                })
                console.log(userDetail)

                // console.log(data);

            },
            //login failed
            () =>
            {
                setUser({...user,
                    error:true,
                    message:"username and password doesn't match",
                    redirectToHome:false});
                // console.log('Login failed');
                // console.log(user.message);
            }
        ));

        //提交对应的内容



    }

    const showError = () => {
        return (
            <div
                className="alert alert-danger"
                style={{display:user.error?'' : 'none'}}
            >
                {user.message}
            </div>
        );
    }

    const redirectToProducts=() => {
        if(user.redirectToHome) {
            return <Redirect to={appConstants.videoGamesRoute}/>
        }
    }

    // const showSuccess=() => {
    //     return(
    //         <div
    //             className="alert alert-info"
    //             style={{display:user.success?'': 'none'}}
    //         >
    //             New account is created. Please sign in
    //         </div>
    //     );
    // }


    return (
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <div className={classes.paper}>
                <Avatar className={classes.avatar}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Sign in
                </Typography>
                {/*<Formik*/}
                {/*    validationSchema={LoginSchema}*/}
                {/*>*/}
                {/*    {({ errors, touched }) => (*/}
                {/*        */}
                {/*    )}*/}

                {/*</Formik>*/}

                {showError()}

                <form className={classes.form} noValidate onSubmit={handleLogin}>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email Address"
                        name="username"
                        autoComplete="email"
                        type='email'
                        autoFocus
                        value={user.username}
                        onChange={handleFormControl}

                        InputProps={{
                            className: classes.input,
                            startAdornment: (
                                <InputAdornment position="start">
                                    <UsernameIcon />
                                </InputAdornment>
                            ),
                        }}
                    />

                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                        value={user.password}
                        onChange={handleFormControl}

                        InputProps={{
                            className: classes.input,
                            startAdornment: (
                                <InputAdornment position="start">
                                    <PasswordIcon />
                                </InputAdornment>
                            )
                        }}
                    />

                    {/*<FormControlLabel*/}
                    {/*    control={<Checkbox value="remember" color="primary"/>}*/}
                    {/*    label="Remember me"*/}
                    {/*    onChange={e => handleChange(e)}*/}
                    {/*/>*/}
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                        disabled={!user.username || !user.password}
                    >
                        Sign In
                    </Button>
                    <Grid container>
                        {/*<Grid item xs>*/}
                        {/*    <Link href="#" variant="body2">*/}
                        {/*        Forgot password?*/}
                        {/*    </Link>*/}
                        {/*</Grid>*/}
                        <Grid item>
                            <NavLink to={appConstants.registerRoute} variant="body2">
                                {"Don't have an account? Sign Up"}
                            </NavLink>
                        </Grid>
                    </Grid>
                </form>
            </div>
            {redirectToProducts()}
            <Box mt={8}>
                <Copyright />
            </Box>
        </Container>
    );
}

