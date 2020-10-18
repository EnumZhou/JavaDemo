export const read = productId => {
    return fetch(`${process.env.REACT_APP_API_URL}/products/id/${productId}`, {
        method: "GET"
    })
        .then(response => {
            console.log(response)
            return response.json();
        })
        .catch(err => console.log(err));
};
