export  const appConstants = {
    // constants for routes
    loginRoute: '/login',
    homeRoute: '/home',
    videoGamesRoute: '/products',
    addProductRoute: '/add-product',
    registerRoute: '/register',
    logoutRoute:'/logout',
    cartRoute: '/cart',
    editRoute: '/edit-product',
    userProfileRoute: '/user-profile',
    updateProfileRoute:'/update-profile',
    adminDashboadRoute:'/admin',

    // actions
    LOGIN: 'LOGIN',
    LOGOUT:'LOGOUT',
    ADD_USER: 'ADD_USER',
    GET_PRODUCTS: 'GET_PRODUCTS',
    ADD_PRODUCT: 'ADD_PRODUCT',
    EDIT_PRODUCT: 'EDIT_PRODUCT',
    CHECK_LOGIN:'CHECK_LOGIN',
    GET_USER_BY_USERNAME: 'GET_USER_BY_USERNAME',
    PLACE_ORDER: 'PLACE_ORDER',
    GET_ORDER_BY_USERID: 'GET_USER_BY_USERID',

    // products fields
    product_field : [
        
        {
            name: 'category',
            displayName: 'Category',
            type: 'text',

        },

        {
            name: 'name',
            displayName: 'Name',
            type: 'text',

        },


        {
            name: 'platform',
            displayName: 'Platform',
            type: 'text'
        },
        {
            name: 'price',
            displayName: 'Price',
            type: 'text'
        },
        {
            name: 'stock',
            displayName: 'Stock',
            type: 'number'
        },
        {
            name: 'image',
            displayName: 'Image',
            type: 'text'
        },
    ],


    //User_Detail_Field
    user_detail_field: [

        {
            name: 'address1',
            displayName: 'Address1',
            type: 'text',

        },

        {
            name: 'address2',
            displayName: 'Address2',
            type: 'text',

        },


        {
            name: 'city',
            displayName: 'City',
            type: 'text'
        },
        {
            name: 'email',
            displayName: 'Email',
            type: 'email'
        },
        {
            name: 'name',
            displayName: 'Name',
            type: 'text'
        },
        {
            name: 'phone',
            displayName: 'Phone',
            type: 'text'
        },
    ],


    // cart actions

    ADD_TO_CART :'ADD_TO_CART',
    REMOVE_ITEM : 'REMOVE_ITEM',
    SUB_QUANTITY :'SUB_QUANTITY',
    ADD_QUANTITY : 'ADD_QUANTITY',
    ADD_SHIPPING : 'ADD_SHIPPING',


}
