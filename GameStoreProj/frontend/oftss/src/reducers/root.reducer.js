import {productsReducer} from "./products.reducer";
import {combineReducers} from "redux";
import {authReducer} from "./auth.reducer";

export const rootReducer = combineReducers({
    products:productsReducer,
    user:authReducer,
});
