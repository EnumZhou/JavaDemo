import axios from "axios";

export const registerEmail = (email) => {
    console.log(email)
    const registerEmailPromise =axios.post(`${process.env.REACT_APP_API_URL}/sendMail1`,email)
        // .then(res=> {
        //     console.log(res)
        //     return {
        //         success: true,
        //     }
        // })
        // .catch(err=> {
        //     console.log(err)
        //     return {
        //         success: true,
        //     }
        // })

    return {
        payload:registerEmailPromise
    }

}
