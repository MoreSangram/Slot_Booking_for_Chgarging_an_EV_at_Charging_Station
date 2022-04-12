import React, { Component } from 'react';
import { BrowserRouter,Link, Route, Switch} from 'react-router-dom';
import BookSlot from "./BookSlot";
import BookHistory from "./BookHistory";
import CancelBooking from "./CancelBooking";
import CustomerProfile from "./CustomerProfile";
import Complain from './Complain';
import mystore1 from '../Store1';

export default class CustomerPage extends Component {

    constructor(props)
    {
        super(props)
    }

    // this methode help to fetch the paticular full customer information (specific customer ) ! needed to complete 
    componentDidMount = () =>{
        fetch("")
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
                        <Link className="nav-link" to="/BookSlot" style={{ color: "white" }}>BookSlot </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/BookHistory" style={{ color: "white" }}>BookHistory </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/updateProfile" style={{ color: "white" }}>Profile </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/Complain" style={{ color: "white" }}>Complain </Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/logout" style={{ color: "white" }} onClick={this.logout}>Logout </Link>
                    </li>
                </ul>

                <Switch>
                    <Route path="/BookSlot" component={BookSlot} />
                    <Route path="/BookHistory" component={BookHistory} />
                    <Route path="/updateProfile" component={CustomerProfile} />
                    <Route path="/Complain" component={Complain} />
                </Switch>
            </div>
            </BrowserRouter>
        );
    }
}