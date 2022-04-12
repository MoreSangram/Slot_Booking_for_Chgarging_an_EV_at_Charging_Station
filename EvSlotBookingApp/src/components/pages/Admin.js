import React, { Component } from 'react';
import Home from "../Home";
import GetCustomer from './GetCustomer';
import GetDistributer from './GetDistributer';
import LatestBooking from './LatestBooking';
import Reports from './Reports';
import {BrowserRouter, Link, Route, Switch,  Redirect} from 'react-router-dom';
import mystore1 from '../Store1';

export default class Admin extends Component {

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
                        <Link className="nav-link" to="/Home" style={{ color: "white" }}>Home</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/registeredcustomer" style={{ color: "white" }}>Get Customer</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/registereddistributer" style={{ color: "white" }}>Get Distributer </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/LatestBooking" style={{ color: "white" }}>LatestBooking </Link>
                    </li>
                    {/* <li className="nav-item">
                        <Link className="nav-link" to="/Reports" style={{ color: "white" }}></Link>
                    </li> */}
                    <li className="nav-item">
                        <Link className="nav-link" to="/logout" style={{ color: "white" }} onClick={this.logout}>Logout</Link>
                    </li>
                </ul>

                <Switch>
                    <Route path="/registeredcustomer" component={GetCustomer} />
                    <Route path="/registereddistributer" component={GetDistributer} />
                    <Route path="/LatestBooking" component={LatestBooking} />
                    <Route path="/Reports" component={Reports} />
                </Switch>
            </div>
            </BrowserRouter >
        )
    }
}

/*import React, { Component } from 'react';
import { BrowserRouter,Link, Route, Switch} from 'react-router-dom';
import BookCylinder from "./BookCylinder";
import BookHistory from "./BookHistory";
import CancelBooking from "./CancelBooking";
import Complain from './Complain';
import mystore1 from '../Store1';
import GetCustomer from './GetCustomer';
import GetDistributer from './GetDistributer';
import LatestBooking from './LatestBooking';
import Reports from './Reports';

export default class Admin extends Component {

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
                <h1> Welcome { JSON.parse(localStorage.getItem("loggedinuser")).name}</h1>
                <ul className="nav nav-tabs">
                    <li className="nav-item">
                        <Link className="nav-link" to="/Home" style={{ color: "white" }}>Home</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/registeredcustomer" style={{ color: "white" }}>Get Customer</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/registereddistributer" style={{ color: "white" }}>Get Distributer </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/LatestBooking" style={{ color: "white" }}>LatestBooking </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/Reports" style={{ color: "white" }}>Report</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/logout" style={{ color: "white" }} onClick={this.logout}>Logout</Link>
                    </li>
                </ul>
                <Switch>
                    <Route path="/registeredcustomer" component={GetCustomer} />
                    <Route path="/registereddistributer" component={GetDistributer} />
                    <Route path="/LatestBooking" component={LatestBooking} />
                    <Route path="/Reports" component={Complain} />
                </Switch>
            </div>
            </BrowserRouter>
        );
    }
}
*/