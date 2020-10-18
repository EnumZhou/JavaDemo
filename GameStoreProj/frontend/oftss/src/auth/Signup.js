import React, {useState} from "react";
import Layout from "../components/Layout";
import 'bootstrap/dist/css/bootstrap.min.css';
import {useDispatch} from "react-redux";
import {addUser} from "../actions/auth.action";
import {registerEmail} from "../actions/email.action";


const Signup = () => {

    const [user,setUser] = useState({
        username:'',
        password:'',
        error:false,
        success:false,
        message:'',
    });

    // const {username,password} =user;

    const dispatch = useDispatch();

    const handleChange= name => event => {
            setUser({...user,[name]:event.target.value});
    };

    // const register = (username,password) => {
    //     console.log(username,password);
    // }
    const clickSubmit = (event => {
        event.preventDefault();
        // register(username,password);
        const data=dispatch(addUser(user));

        data.then(res => {
            // console.log(res.payload.success);
            if(res.payload.success){
                console.log('res.success',res.payload.success);
                setUser({...user,error:false,success:true});
                const addressList = [];
                addressList.push(user.username)
                console.log(addressList)
                registerEmail(addressList);
            }
            else {
                // console.log(res);
                // console.log('res.success',res.payload.success);
                // console.log(res.payload.message);
                setUser({...user,error:true,message:res.payload.message});
            }
        })

    });


    const signUpForm = () => {

        return (
            <form>
                <div className="form-group">
                    <label className="text-muted">Username</label>
                    <input onChange={handleChange('username')}
                           type="email" required
                           placeholder='Email'
                           className="form-control"
                           value={user.username}
                    />
                </div>

                <div className="form-group">
                    <label className="text-muted">Password</label>
                    <input onChange={handleChange('password')}
                           type="password" required
                           placeholder='Password'
                           className="form-control"
                           value={user.password}
                    />
                </div>
                <button onClick={clickSubmit} className="btn-primary">Submit</button>
            </form>
            )
    };

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

    const showSuccess=() => {
        return(
            <div
                className="alert alert-info"
                style={{display:user.success?'': 'none'}}
            >
                New account is created. Please sign in
            </div>
        );
    }

    return (
        <Layout
            title="Sign up"
            classname="container col-md-8 offset-md-2"
        >
            {showSuccess()}
            {showError()}
            {signUpForm()}
            {/*{JSON.stringify(user)}*/}
        </Layout>
    );
}

export default Signup;
