import {appConstants} from "../constants/constants";
import axios from "axios";

export const login = (user,succeed,fail) => {
    const userFormData = new FormData();
    userFormData.append('username',user.username);
    userFormData.append('password',user.password);

    async function signIn() {
        return fetch(
            `${process.env.REACT_APP_API_URL}/login`,
            {
                method: 'POST',
                body: userFormData,
                // withCredentials : true carry/set cookie
                credentials:'include'
            }
        );
    }
    const loginPromise = signIn()
        .then (res => res.json())
        .then(res => {
            if (res.success) {
                succeed();
            } else {
                fail();
            }
            return res;
        });

    return {
        type: appConstants.LOGIN,
        payload: loginPromise
    }
}


export const addUser = (user) => {
    const newUser={
        username:user.username,
        password:user.password
    }

    const addUserPromise = axios.post(`${process.env.REACT_APP_API_URL}/users`,newUser)
        .then(res => {
        // console.log("response.success:",res);
        if(res.data.success) {
            // console.log("In success",res.data.success)
            return {
                success:true,
                newUser
            }
        }
        return {
            success:false,
            user:null,
            message:'Username Exists'
        }
    })
        .catch(err => {
            // console.log("In error:",err);
            return {
                success:false,
                user:null
            }
        })

    return {
        type: appConstants.ADD_USER,
        payload:addUserPromise,
    }
}


export const getUserByUsername =(username)=>{
    const getUserByUsernamePromise = axios.get(`${process.env.REACT_APP_API_URL}/users/username/${username}`)
        .then(res => {
            return{
                    success:true,
                    user:res.data
            }
        }).catch(err => {
            return {
                success:false,
                user:null
            }
        })

    return{
        type:appConstants.GET_USER_BY_USERNAME,
        payload:getUserByUsernamePromise
    }
}



// login status
export const isAuth = () => {
    const login_statusPromise=axios.get(`${process.env.REACT_APP_API_URL}/checklogin`,{ withCredentials: true })
        .then(res =>
            {
                // console.log(res);
                // console.log(res.data.user.userProfile);
                if(res.data.success) {
                    //console.log("loggedIn:",res.data.success)
                    return {
                        login_status:res.data.success,
                        userProfile:res.data.user.userProfile,
                    }
                }
                else {
                    //console.log("loggedIn:",res.data.success)
                    return {
                        login_status:res.data.success,
                        userProfile:null,
                    }
                }

            }

        );

    return {
        type: appConstants.CHECK_LOGIN,
        payload:login_statusPromise,
    }
}

// update user-details

export const updateUserDetail =(userDetail)=>{
    const updateUserDetailPromise = axios.put(`${process.env.REACT_APP_API_URL}/user-details`,userDetail)
        .then(res => {
            if(res) {
                console.log('update success',res.success)
                return {
                    success: true,
                    userDetail:userDetail,
                }
            }
            console.log('update success',res.success)
            return {
                success: false,
                userDetail:null,
            }
        }).catch(err => {
            console.log('update success',false)
            return {
                success:false,
                userDetail:null
            }
        })


    return{
        type:appConstants.GET_USER_BY_USERNAME,
        payload:updateUserDetailPromise
    }
}



// export const isAuthenticated  = () => {
//     return isAuth().payload.login_status;
// }



export const logout = () => {
    const login_statusPromise=axios.get(`${process.env.REACT_APP_API_URL}/logout`,{ withCredentials: true })
        .then(res =>
            {
                console.log(res);
                // if(res.data.success) {
                //     // console.log("loggedIn:",res.data.success)
                //     return {
                //         login_status:res.data.success
                //     }
                // }
                // else {
                //     // console.log("loggedIn:",res.data.success)
                //     return {
                //         login_status:res.data.success
                //     }
                // }

            }

        );

    return {
        type: appConstants.CHECK_LOGIN,
        payload:login_statusPromise,
    }
}








