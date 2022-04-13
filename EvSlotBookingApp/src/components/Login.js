import React from 'react';
import CustomerForm from './CustomerForm';
import './Login.css';
import mystore1 from './Store1';



export default class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state =
        {
            user: "",
            password: "",
            customer: {},
            distributer: {},
            admin: {},
            msg:"",
            loginerror: ""

        }
    }


    handleChange = (e) => {

        const input = e.target;
        const nm = input.name;
        const val = input.value;
        this.setState({ [nm]: val });
    }

/*
   checkLogin = () => {
       let user =this.user.value;
       let password = this.password.value;

       const url = "http://localhost:8080/checkLogin?user="+user+"&password="+password;

       fetch(url)
       .then(response => response.text())
       //.then(data => this.setState({msg : data}));
       .then(data => {
            if(data =="customer")
            {
                this.props.history.push("/customerhome/"+user);
            }
            else if(data =="distributer")
            {
                this.props.history.push("/distributerhome/"+user);
            }
            else if(data =="admin")
            {
                this.props.history.push("/adminhome/"+user);
            }
            else if(data =="")
            {
                this.setState({loginerror:"Wrong ID/Password  "});
            }


    }
    )}
   */


    submitData = (e) => {
        e.preventDefault();
        /* alert("form is getting submitted ");
         console.log(this.state);*/

        const reqData =
        {
            method: 'POST',
            headers:
            {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            },
            body: JSON.stringify
                ({
                    //this must matches with the entity entered in springboot
                    user: this.state.user,
                    password: this.state.password,
                   // role:
                })
        }

        fetch("http://localhost:8080/checkLogin", reqData)
            .then(resp => resp.text())
            .then(data => {
                if (data.length != 0) 
                {
                    console.log(data);
                        const json = JSON.parse(data);
                         // var response = JSON.parse(data);
                         // console.log(response['role']);
                        if (json.login_tbl.role == "Customer") {
                            this.setState({ customer: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.customer));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/customerhome")
                        }
                        else if (json.login_tbl.role == "Distributor") {
                            this.setState({ distributer: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.distributer));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/distributerhome")
                        }
                        else if (json.login_tbl.role == "Admin")
                        {
                            this.setState({ admin: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.admin));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/adminhome")
                        }
                }  
                else 
                {
                    this.setState({ loginerror: "wrong Id/password" });
                }
     
            }
            )}
        
        
            customerForm = ()=>{
                this.props.history.push("/CustomerForm");
            }

            distributorForm = ()=>{
                this.props.history.push("/DistributerForm");
            }
            
           
            
            forgetForm = ()=>{
                this.props.history.push("/Forgot");
            }


    render(){

        return (
            <div >
            <div className="Form my-5 mx- 3 " >
                <div className="container " >
                    <div className="row no-gutters " style={{ padding: "10px" }}>
                        {/* <div className="col-lg-5 my-16 p-12">
                            <img src="./images/ucopy2.jpg" className="img-fluid" style={{ marginTop: "10px" }} alt="Image Cylinder" />
                        </div> */}
                        <div className="col-lg px-5">
                            <h1 className="font-weight-bold py-3"> Welcome,Book your charging slot now  </h1>
                            <h4> Sign into your account </h4>
                            <form >
                                <div className="form-row">
                                    <div className="col-lg-7">
                                        <input type="text" name="user" placeholder="Username" className="form-control my-2 p-2"  ref="user" value={this.state.user} onChange={this.handleChange} /><span className="text-danger font-weight-bold "></span>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div className="col-lg-7">
                                        <input type="password" name="password" placeholder="Password" className="form-control my-2 p-2 "  ref="password" value={this.state.password} onChange={this.handleChange} /><span className="text-danger font-weight-bold"></span>
                                    </div>
                                </div>
                                <br/>
                                <div className="form-row">
                                    <div className="col-lg-6">
                                        <input type="submit" name="login" value="Login" className="btn btn-success" onClick={this.submitData} />
                                    </div>
                                </div>
                                <br />
                                <button className="btn btn-warning" onClick={this.forgetForm} >Forget password </button><span> </span>
                                <br />
                                <br/>
                                <p style={{color:"darkred"}}>Dont have an account ? &nbsp;
                                    <button className="btn btn-info" onClick={this.customerForm}>Customer Registration</button>&nbsp;
                                    <button className="btn btn-info" onClick={this.distributorForm}>Distributor Registration</button> 
                                </p>
                            </form>
                            <br/>
                            <p>{this.state.loginerror}</p>
                        </div>
                    </div>
                </div>
            </div>
            </div >
        );
    }
}





