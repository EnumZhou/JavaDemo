import axios from "axios";
import {appConstants} from "../constants/constants";

export const getProducts = () => {
    const  getProductsPromise = axios.get(`${process.env.REACT_APP_API_URL}/products`)
        // .then (res => {
        //     if(res) {
        //         console.log(res.data);
        //         return {
        //             success:true,
        //             products:res.data
        //         }
        //     }
        //     return {
        //         success:false,
        //         products:null
        //     }
        // })
    return {
        type: appConstants.GET_PRODUCTS,
        payload: getProductsPromise,
    };
};

// export const  getProduct =(id)=> {
//     const  getProductsPromise = axios.get(`${process.env.REACT_APP_API_URL}/products/{id}`);
// }

export const addProduct = (product) => {
    const addProductPromise = axios.post(`${process.env.REACT_APP_API_URL}/products`,product)
        .then(res => {
            if (res.success){
                return {
                    success: true,
                    product
                }
            }
            return {
                success: false,
                product:null,
            }
        })
        .catch(err => {
            return {
                success:false,
                product:null
            };
        });

    return {
        type: appConstants.ADD_PRODUCT,
        payload: addProductPromise,
    }
}


export const editProduct = (product) => {
    const editProductPromise = axios.put(`${process.env.REACT_APP_API_URL}/products`,product)
        .then(res => {
            // console.log(res)
            if (res ){
                // console.log('edit: succesffully')
                return {
                    success: true,
                }
            }
            //console.log('edit:',res)
            return {
                success: false,
            }
        })
        .catch(err => {
            console.log('edit error:',false)
            return {
                success:false,
            };
        });

    return {
        type: appConstants.EDIT_PRODUCT,
        payload: editProductPromise,
    }
}
