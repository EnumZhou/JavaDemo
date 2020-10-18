export const addItem = (item, next) => {
    let cart = [];

    if (localStorage.getItem("cart")) {
            cart = JSON.parse(localStorage.getItem("cart"))
            if (cart.find(p => p.id === item.id)){
                    console.log("already in")
            }else{
                cart = JSON.parse(localStorage.getItem("cart"));
                console.log(cart)
                cart.push({...item,count:1})
                localStorage.removeItem("cart")
                localStorage.setItem("cart",JSON.stringify(cart))
            }
        }
    else{
        cart.push({
            ...item,
            count: 1
        });

        cart = Array.from(new Set(cart.map(p => p._id))).map(id => {
            return cart.find(p => p._id === id);
        });

        localStorage.setItem("cart", JSON.stringify(cart));
        next();


    }

};

// export const itemTotal = () => {
//     if (typeof window !== "undefined") {
//         if (localStorage.getItem("cart")) {
//             return JSON.parse(localStorage.getItem("cart")).length;
//         }
//     }
//     return 0;
// };

export const getCart = () => {

        if (localStorage.getItem("cart")) {
            return JSON.parse(localStorage.getItem("cart"));
        }

    return [];
};

export const updateItem = (productId, count) => {
    let cart = [];
    console.log(productId,count)

        if (localStorage.getItem("cart")) {
            cart = JSON.parse(localStorage.getItem("cart"));
        }

        cart.map((product, m) => {
            if (product.id === productId) {
               cart[m].count = count;
            }
        });

        localStorage.setItem("cart", JSON.stringify(cart));

};

export const removeItem = productId => {
    let cart = [];
    if (typeof window !== "undefined") {
        if (localStorage.getItem("cart")) {
            cart = JSON.parse(localStorage.getItem("cart"));
        }

        cart.map((product, i) => {
            if (product._id === productId) {
                cart.splice(i, 1);
            }
        });

        localStorage.setItem("cart", JSON.stringify(cart));
    }

    return cart;
};

// export const emptyCart = next => {
//     if (typeof window !== "undefined") {
//         localStorage.removeItem("cart");
//         next();
//     }
// };
