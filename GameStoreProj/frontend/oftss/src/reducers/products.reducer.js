import {appConstants} from "../constants/constants";

export const productsReducer =(state=null, action) => {
    switch (action.type)
    {
        case appConstants.GET_PRODUCTS:
            return action.payload.data;

        case appConstants.ADD_PRODUCT:
            return action.payload.success && state ? [...state,action.payload.product] : state;

        default:
            return state;
    }
}
