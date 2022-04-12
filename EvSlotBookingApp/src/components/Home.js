import React from "react";
import Login from "./Login";
import AboutUs from "./AboutUs";
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
import "../App.css";
import CustomerForm from "./CustomerForm";
import DistributerForm from "./DistributerForm";
import ErrorComp from "./ErrorComp";
import CustomerPage from "./pages/CustomerPage";
import DistributerPage from "./pages/DistributerPage";

import Admin from "./pages/Admin";
import mystore1 from "./Store1";
import ForgettPassword from "./pages/ForgettPassword";


export default class Home extends React.Component {


    constructor(props)
    {
        super(props)
       this.state = {
            flag:false
        }
    }

    openDropDown() {
        var divToggle = document.getElementById("abc");
        if (divToggle.style.display == "block") {
            divToggle.style.display = "none";
        } else {
            divToggle.style.display = "block";
        }
        console.log("asdf");
    }

    render() {
        mystore1.subscribe(()=>{this.setState({flag:mystore1.getState().loggedin})})
        return (
            <BrowserRouter>
                <div style={{display:this.state.flag?'none':'block'}}>
                    <ul className="nav nav-tabs">
                        <li className="nav-item"><Link className="nav-link" to="/Login" style={{ color: "white" }}>Login</Link></li>
                        {/*<li className="nav-item"><Link className="nav-link" to="/Register" style={{color:"white"}}>Register</Link></li>  */}
                        

                        <li className="nav-item ">
                            <div className="nav-link" onClick={this.openDropDown} style={{ color: "white" }}>Register<span style={{ marginTop: "-3px" }}><i style={{ marginLeft: "10px", color: "white" }} class="arrow down"></i></span></div>
                            <div style={{ position: "relative", background: "blue", display: "none" }} id="abc">
                                <div style={{ position: "absolute", background: "blue", width: "100%", border: "1px solid blue", textAlign: "center" }}>
                                    <Link to="/CustomerForm" className="dropdownBox"><div className="dropdownBoxDiv">Customer</div></Link>
                                    <Link to="/DistributerForm" className="dropdownBox"><div className="dropdownBoxDiv">Distributer</div></Link>
                                </div>
                            </div>
                        </li>

                        <li className="nav-item"><Link className="nav-link" to="/Aboutus" style={{ color: "white" }}>About us </Link></li>

                </ul >

                    <Switch>
                        <Route path="/Login" component={Login} />
                        <Route path="/CustomerForm" component={CustomerForm} />
                        <Route path="/DistributerForm" component={DistributerForm} /> 
                        <Route path="/Aboutus" component={AboutUs} />
                        {/*<Route component={ErrorComp} />*/}
                    </Switch>
            </div>
            
            <Route path="/customerhome" component={CustomerPage}/>
            <Route path="/distributerhome" component={DistributerPage}/>
            <Route path="/adminhome" component={Admin}/>
            <Route path="/Forgot" component={ForgettPassword}/>

           
            </BrowserRouter>
            

          

        );
    }

}