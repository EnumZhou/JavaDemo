import {appConstants} from "../constants/constants";

export const authReducer = (state=null, action) => {
    switch (action.type) {
        case appConstants.LOGIN:
            //console.log(action.payload);
            return action.payload.success && state ? [...state,action.payload.user] : state;

        case appConstants.ADD_USER:
            //console.log(action.payload);
            return action.payload.success && state ? [...state,action.payload.user] : state;

        case appConstants.CHECK_LOGIN:
            //console.log(action.payload);
            return action.payload.login_status && state? [...state,action.payload.login_status]:state;

        case appConstants.GET_USER_BY_USERNAME:
            console.log("GET USER BY USERNAME",action.payload);
            return action.payload.user && state ? [...state,action.payload.user] : state;

        default:
            return state;

    }
}
