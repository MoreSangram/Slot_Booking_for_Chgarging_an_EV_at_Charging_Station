import React, { Component } from 'react'
import { BrowserRouter,Link, Route, Switch} from 'react-router-dom';
import Booking from './Booking';
import CustomerInfo from './CustomerInfo';
import OrderDetails from './OrderDetails';
import Complaint from './Complaint';
import mystore1 from '../Store1';

export default class DistributerPage extends Component {


    constructor(props)
    {
        super(props)
    }

    logout=()=>{
        mystore1.dispatch({type:"LOGGEDOUT"});
        localStorage.removeItem("loggedinuser");
        this.props.history.push("/Home")
    }
    render() {
        return (
            
             <BrowserRouter>
            <div>
            <h1 style={{color:"ThreeDDarkShadow"},{backgroundColor:"yellow"}}> Welcome { JSON.parse(localStorage.getItem("loggedinuser")).name}</h1>

                <ul className="nav nav-tabs">
                    
                    <li className="nav-item">
                        <Link className="nav-link" to="/get_bookdetails" style={{ color: "white" }}>Get Booking Deatils </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/get_custinfo" style={{ color: "white" }}>Get Customer Information </Link>
                    </li>
                    {/*<li className="nav-item">
                        <Link className="nav-link" to="/orderdetails" style={{ color: "white" }}> Get Orders</Link>
        </li>*/}
                    <li className="nav-item">
                        <Link className="nav-link" to="/Complaint" style={{ color: "white" }}>Get Raised Complaint </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/logout" style={{ color: "white" }} onClick={this.logout}>Logout </Link>
                    </li>
                </ul>

                <Switch>
                    <Route path="/get_bookdetails" component={Booking} />
                    <Route path="/get_custinfo" component={CustomerInfo} />
                   {/* <Route path="/orderdetails" component={OrderDetails} />*/}
                    <Route path="/Complaint" component={Complaint} />
                </Switch>
            </div>
            </BrowserRouter>
        )
    }
}
