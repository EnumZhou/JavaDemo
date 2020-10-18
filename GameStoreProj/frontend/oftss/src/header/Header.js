import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import {NavLink} from "react-router-dom";
import {appConstants} from "../constants/constants";
import {withRouter} from "react-router-dom";
import {useDispatch} from "react-redux";
import {isAuth, logout} from "../actions/auth.action";




const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
}));



const isActive =(history,path) => {
    if(history.location.pathname === path) {
        return {color: '#ff9900'};
    } else {
        return {color: "#ffffff"};
    }
};

const Header =({history}) => {
        const classes = useStyles();

        const [status,setStatus] = useState(false);
        const [isAdmin,setIsAdmin] = useState(false);


        const dispatch =useDispatch();

        dispatch(isAuth())
            .then(res => {
            //console.log('login_status:',res.payload.login_status);
                if(res.payload.login_status){
                    setStatus(res.payload.login_status);
                    const userProfile=res.payload.userProfile;
                    console.log(userProfile);
                    return userProfile.authority === 'role_admin' ?
                        setIsAdmin(true) : setIsAdmin(false);
                }
        })

        //update mount
        // useEffect( () => {
        //     if(status)
        //     {
        //         const userProfile1=JSON.parse(localStorage.Authority);
        //         if(userProfile1.authority === 'role_admin') {
        //             setIsAdmin(true);
        //         } else{
        //             setIsAdmin(false);
        //         }
        //     } else {
        //         setIsAdmin(false);
        //     }
        //
        // },[status]);



        const handleLogout=() =>
        {
            logout();
            dispatch(isAuth())
                .then(res => {
                    //console.log('login_status:',res.payload.login_status);
                    setStatus(res.payload.login_status);
                    setIsAdmin(res.payload.login_status);
                    localStorage.removeItem("user");
                    localStorage.removeItem("ud");
                    localStorage.removeItem("Authority");
                })

        }

        // const redirectToHome=() => {
        //     if(values.redirectStatus)
        //     {
        //         return (
        //             <Redirect to={appConstants.homeRoute}/>
        //         )
        //     }
        // }


        const loginLogout = (status) => {
            return (
                 status ?
                     <div>
                         <Button onClick={handleLogout} color="inherit" style={isActive(history)}>Logout</Button>
                         {renderUserDashBoardOrAdmin(!isAdmin)}
                     </div>

                    :<div>
                         <NavLink to={appConstants.loginRoute}>
                         <Button color="inherit" style={isActive(history,'/login')}>Login</Button>
                         </NavLink>
                     </div>
            );
        }

        const renderUserDashBoardOrAdmin= (isAdminOrUser) => {

            return (
                isAdminOrUser ?
                <NavLink to={appConstants.userProfileRoute}>
                    <Button color="inherit" style={isActive(history,'/login')}>Profile</Button>
                </NavLink>
                    :
                    <NavLink to={appConstants.adminDashboadRoute}>
                        <Button color="inherit" style={isActive(history)}>DashBoard</Button>
                    </NavLink>
            );

        }

        const renderHeader = (isAdmin) => {
            return (
                isAdmin?
                    <Toolbar>
                        <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" className={classes.title}>
                            GamesStore
                        </Typography>
                        <NavLink to={appConstants.videoGamesRoute}>
                            <Button color="inherit" style={isActive(history,'/video-games')}>Games</Button>
                        </NavLink>
                        {/*<NavLink to={appConstants.addProductRoute}>*/}
                        {/*    <Button color="inherit" style={isActive(history,'/add-product')}>Add Product</Button>*/}
                        {/*</NavLink>*/}
                        {loginLogout(status)}
                    </Toolbar>
                    :
                    <Toolbar>
                        <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" className={classes.title}>
                            GamesStore
                        </Typography>

                        <NavLink to={appConstants.homeRoute}>
                            <Button color="inherit" style={isActive(history,'/home')}>Home</Button>
                        </NavLink>

                        <NavLink to={appConstants.videoGamesRoute}>
                            <Button color="inherit" style={isActive(history,'/video-games')}>Games</Button>
                        </NavLink>

                        <NavLink to={appConstants.cartRoute}>
                            <Button color="inherit" style={isActive(history,'/cart')}>CART</Button>
                        </NavLink>

                        {loginLogout(status)}
                    </Toolbar>
            )
        }

        return (
            <div className={classes.root}>
                <AppBar position="static">
                    {renderHeader(isAdmin)}
                </AppBar>
            </div>
        );

}

export default withRouter(Header);

