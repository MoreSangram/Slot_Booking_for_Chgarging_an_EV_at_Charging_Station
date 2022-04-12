import React, { Component } from 'react'

export default class ForgettPassword extends Component {
    constructor(props) {
        super(props);
        this.state =
        {
            user: "",
            password: "",
            login:{}
            
        }
    }

    handleChange = (e) => {

        const input = e.target;
        const nm = input.name;
        const val = input.value;
        this.setState({ [nm]: val });
    }

     updateData =(e) =>{
        /*e.preventDefault();
        /* alert("form is getting submitted ");
         console.log(this.state);*/

        const reqData =
        {
            method: 'GET',
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
                   
                })
        }
    
       // alert("Changed Password");
     fetch("http://localhost:8080/changePassword", reqData)
     .then(resp => resp.json())
     /*.then(data => this.setState({login:data , success : true }))  */
     //.then(data => this.setState({login:data , success : true }))
     

     .then(data => {
        if (data.length != 0) 
        {
           
            console.log(data);
            const json = JSON.parse(data);
            if (json.login_tbl.user == this.state.user) 
            {
                this.setState({ password: json });
            }
        }
        alert("Changed Password");
        })
    }

     
     loginForm = ()=>{
        this.props.history.push("/Login");
    }

    render() {
        return (
            <div>
                <br/>
                <div className="container"><br />
                    <h2 className="text-primary text-center">Forgot Password ! </h2><br></br>

                    <div className="col-lg-8 m-auto d-block">
                <form onSubmit={ this.handleSubmit }>
                   

                    <div className="form-group">
                        <label><b>Enter User:</b></label>
                        <input type="text" name="user" className="form-control"  autocomplete="off" value={this.state.user} onChange={this.handleChange}/>
                    </div> 
                    <br/><br/>    

                      <div className="form-group">
                        <label><b>Enter  New Password  :</b></label>
                        <input type="password" name="password" placeholder="******" className="form-control my-2 p-2 "   value={this.state.password} onChange={this.handleChange} />
                    </div>  
                    <br/><br/> 

                     <button className="btn btn-success"   onClick={this.updateData}> Update </button>&nbsp;&nbsp;<button className="btn btn-primary" onClick={this.loginForm} >Login</button><br/><br/> 
                     <br/><br/>
                     <br/><br/>
                     <br/><br/>

                </form>

                </div>

                </div>
            </div>
        )
    }
}

