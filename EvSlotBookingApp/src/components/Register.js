import React from "react";
import CustomerForm from "./CustomerForm";
import DistributerForm from "./DistributerForm";
import { Link,Route,Switch } from 'react-router-dom';


export default class Register extends React.Component{
    render(){
        return(
            <div>
                  <ul className="nav nav-tabs">
                        <li className="nav-item"><Link className="nav-link" to="/CustomerForm" style={{color:"white"}}>Register As Customer</Link></li> 
                        <li className="nav-item"><Link className="nav-link" to="/DistributerForm" style={{color:"white"}}>Register As Distributer</Link></li> 
                  </ul >
                <Switch>
                    <Route path="/CustomerForm" component={CustomerForm} />
                    <Route path="/DistributerForm" component={DistributerForm} />
                </Switch>

            </div>

        );
    }
}