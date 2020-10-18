import React, {Component} from "react";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import {connect} from "react-redux";
import { Link} from "react-router-dom";
import {getProducts} from "../actions/products.action";
import './Product.scss';
import 'bootstrap/dist/css/bootstrap.min.css';
import {isAuth} from "../actions/auth.action";

class Products extends Component {

    constructor(props) {
        super(props);
        let isAdmin = false;
        this.state = {
            data: [],
            value: '',

        };
        isAuth().payload
            .then(res => {
                //console.log('login_status:',res.payload.login_status);
                if(res.login_status)
                {
                    const userProfile=res.userProfile;
                    console.log(userProfile);

                    return userProfile.authority === 'role_admin' ?
                        this.isAdmin = true : this.isAdmin = false;
                } });

    }

    componentWillMount() {
            // optimize it send request when needed

            // console.log(isAuthenticated());
           //this.setState(!this.props.products && this.props.getProducts())
        this.setState({...this.state,value:null});

        this.state = {
            data: [],
            value: '',
        };
            this.props.getProducts().then(res => {
                // console.log(res.payload.success);
                //console.log('res.success: ',res.payload.data);
                this.setState({data:res.payload.data ,value:null})
                //console.log(this.state.data)
            })
        }

        componentDidMount() {
            !this.props.products && this.props.getProducts();


            // isAuth()
            //     .then(res => {
            //         //console.log('login_status:',res.payload.login_status);
            //         if(res.payload.login_status)
            //         {
            //             const userProfile=res.payload.userProfile;
            //             //console.log(userProfile);
            //             return userProfile.authority === 'role_admin' ?
            //                 this.setState({isAdmin:true}) : this.setState({isAdmin:false});
            //         } });
        }

        renderEdit (isAdmin,product) {

            if(isAdmin){
                return (
                    <Link to={`/edit-product/${product.id}`} className="mr-2">
                        <button className="btn btn-outline-dark">Edit Product</button>
                    </Link>
                );
            }
        }



        handleChange = event => {
            this.setState({value: event.target.value });
                        //console.log(this.state.data)
                        const result = [];
                        if(event.target.value !== "" ) {
                            //console.log(this.state.data)
                            this.state.data.forEach(p => console.log(p.platform))
                            this.state.data.forEach(p => {
                                if (p.platform.toLocaleLowerCase().includes(event.target.value.toString().toLowerCase())) {
                                    //console.log(p)
                                    result.push(p)
                                }
                            })

                            this.setState({data: result});
                        } else {
                            this.props.getProducts().then(res => {
                                // console.log(res.payload.success);
                                //console.log('res.success: ',res.payload.data);
                                this.setState({data:res.payload.data ,value:null})
                                //console.log(this.state.data)
                            })
                        }
        }


    filter () {
        // console.log(this.state)
            return (
                <div style={{
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    marginTop: '1%'
                }}>
                    <button>Sort By Platform</button>&nbsp;&nbsp;
                    <input
                        onChange={this.handleChange}
                        type="text"
                    />
                </div>
            )
        }

        product() {
            // const { data, value } = this.state;
            // console.log(data)
            // console.log(value)
            return (
                <Grid container spacing = {10} style={{marginTop: '2%'}}>
                    {
                        this.state.data.map(p =>
                            <Grid item xs={12} sm ={6} md={4} lg={3} key={p.id}>
                                <Paper>
                                    <img src={p.image} alt={p.name} className="card-img-top"/>
                                    <div className="card-body">
                                        <div  align-items-center="true">
                                            <h3 style={ {margin: 0} } className="card-title">{p.name}</h3>
                                            <div className="card-text">{p.platform}</div>
                                            <div className="card-text">{p.stock}</div>
                                            <div className="card-text">${p.price}</div>
                                            <Link to={`/product/${p.id}`} className="mr-2">
                                                <button className="btn btn-outline-dark">view detail</button>
                                            </Link>
                                            {this.renderEdit(this.isAdmin,p)}
                                        </div>
                                    </div>
                                </Paper>
                            </Grid>
                        )}
                </Grid>
            )
        }


        render() {
               return(
                   <div>
                       <div>
                           {this.filter()}
                           {/*{JSON.stringify(this.state)}*/}
                       </div>
                       {this.product()}
                   </div>
               )
            }
}

function mapStateToProps({products}) {
    // returned object will be merged with component props
    console.log(products);
    return {products};
    //props:{} => props: {products: [...]}
}


export default connect(mapStateToProps,{getProducts})(Products);


