import React from "react";
import { useHistory } from "react-router-dom";

export default class CustomerForm extends React.Component {

    //const history =useHistory;

    constructor(props) {
        super(props);
        this.state={
            name:"",
            user:"",
            password:"",
            conpassword:"",
            email:"",
            contact:"",
            address:"",
            city:"",
            pancard:"",
            //consumer:"",
            customer : { },
            success:"false",
            
            errors:{
                nameerror:"",
                usererror:"",
                passworderror:"",
                conpassworderror:"",
                emailerror:"",
                contacterror:"",
                addresserror:"",
                cityerror:"",
                pancarderror:"",
                //consumererror:"",
               
            },
            namevalid:false,
            uservalid:false,
            passwordvalid:false,
            conpasswordvalid:false,
            emailvalid:false,
            contactvalid:false,
            addressvalid:false,
            cityvalid:false,
            pancardvalid:false,
           // consumervalid:false, 
            formvalid:false
        }

    }
     
    handleChange = (e)=>{

      /* const emailregex = /^[A-Za-z0-9.]{5,}@[A-Za-za-9.]{5,12}\.[a-z]{2,5}$/;
       const contactregex = /^\d{10}$/;
       const pancardregex =  /[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
       const consumerregex = /^\d{17}$/;*/


       const input = e.target;
       const nm = input.name;
       const val = input.value;
       let errors =this.state.errors;
       let nameflag = this.state.namevalid;
       let userflag = this.state.namevalid;
       let passwordflag = this.state.password;
       let conpasswordflag = this.state.conpassword;
       let emailflag= this.state.emailvalid
       let contactflag = this.state.contactvalid;
       let addressflag = this.state.addressvalid;
       let cityflag = this.state.cityvalid;
       let pancardflag = this.state.pancardvalid;
       //let consumerflag = this.state.consumervalid
      

       switch(nm)
       {
           case 'name':
            if((val.length <= 2)||(val.length > 20))
            {
                errors.nameerror="***name length must be between 2 and 20 ";
                nameflag=false;
            }
            else if (val=== "") 
            {
                errors.nameerror="***Please fill the namename field ";
                nameflag=false;
            }  
            else if (!isNaN(val))
            {
                errors.nameerror="***only characters are allowed ! ";
                nameflag=false;
            } 
            else
            {
                errors.nameerror="";
                nameflag=true;
            }
            break;


            case 'user' :

                if((val.length <= 2)||(val.length > 20))
                {
                    errors.usererror="***name length must be between 2 and 20 ";
                    userflag=false;
                }
                else if (val=== "") 
                {
                    errors.usererror="***Please fill the namename field ";
                    userflag=false;
                }  
                else
                {
                    errors.usererror="";
                    userflag=true;
                }
                break;

                case 'password':
                    if(val === "")
                    {
                        errors.passworderror="***Please fill the password field ";
                        passwordflag=false;
                    }
                    else if((val.length <= 5)||(val.length > 8))
                    {
                        errors.passworderror="***passwords length must be between 5 and 8  ";
                        passwordflag=false;
                    }
                
                    else
                    {
                        errors.passworderror="";
                        passwordflag=true;
        
                    }
                    break;
        
                 case'conpassword':
                   if (val ==="")
                   {
                       errors.conpassworderror="***Please fill the retype password  field ";
                       conpasswordflag=false;
        
                   }
                   else if(val.password !== val.conpassword)
                   {
                       errors.conpassworderror="***passwords are not matching  ";
                       conpasswordflag=false;
                   }
                   else
                   {
                        errors.conpassworderror="";
                        conpasswordflag=true;
                   }
        
                   break;


            case'email':
            if(val.indexOf('@') <= -1)
            {
                errors.emailerror="***@ symbol is required email id ! ";
                emailflag=false;
            }
            else if((val.charAt(val.length-4)!=='.' ) && (val.charAt(val.length-3)!=='.' ))
            {
                errors.emailerror="***incorrect email id ! ";
                emailflag=false;

            }
            else if (val=== "") 
            {
                errors.emailerror="***Please fill the email field ";
                emailflag=false;
            }
            else
            {
                  errors.emailerror="";
                  emailflag=true;
            }
            break;
            

           case'contact':
           if(val.length!==10)
           {
               errors.contacterror="***not a valid number ! ";
               contactflag=false;
           }
           else if (val=== "") 
           {
               errors.contacterror="***Please fill the contact field ";
               contactflag=false;
           }
           else
           {
                errors.contacterror="";
                contactflag=true;
           }
           break;


           case'address':
           if((val.length <= 3)||(val.length <= 10))
           {
               errors.addresserror="*** address length must be between 5 to 10 charcters  ";
               addressflag=false;
           }
           else if (val=== "") 
           {
               errors.addresserror="***Please fill the address field ";
               addressflag=false;
           }  
           else
           {
               errors.addresserror="";
               addressflag=true;
           }
           break;

           case'city':
           if((val.length <= 3)||(val.length <= 3))
           {
               errors.cityerror="*** city length must be greater than 3 ";
               cityflag=false;
           }
           else if (val=== "") 
           {
               errors.cityerror="***Please fill the city field ";
               cityflag=false;
           }  
           else
           {
               errors.cityerror="";
               cityflag=true;
           }
           break;

           case'pancard':
           if(val.length!== 10)
           {
                errors.pancarderror="*** invalid pancard_id plz enter correct id ! ";
                pancardflag=false;
           }
           else if (val=== "") 
           {
               errors.pancarderror="***Please fill the pancard  field ";
               pancardflag=false;
           }
           else
           {
               errors.pancarderror="";
               pancardflag=true;
           }
           break;

        //    case'consumer':
        //    if(val.length !== 5)
        //    {
        //          errors.consumererror="*** invalid consumer_id plz enter correct id ! ";
        //          consumerflag=false;
        //    }
        //    else if (val=== "") 
        //    {
        //        errors.consumererror="***Please fill the pancard  field ";
        //        consumerflag=false;
        //    }
        //    else
        //    {
        //         errors.consumererror="";
        //         consumerflag=true;
        //    }
        //    break;
 
       }
       this.setState({errors,[nm] : val ,
            namevalid:nameflag,
            uservalid:userflag,
            passwordvalid:passwordflag,
            conpasswordvalid:conpasswordflag,
            emailvalid:emailflag,
            contactvalid:contactflag,
            addressvalid:addressflag,
            cityvalid:cityflag,
            pancardvalid:pancardflag
            //consumervalid:consumerflag
            },
            ()=>{this.setState({formvalid:this.state.namevalid && this.state.user && this.state.password && this.state.conpassword && this.state.emailvalid && this.state.contactvalid && this.state.addressvalid && this.state.cityvalid && this.state.pancardvalid /*&& this.state.consumervalid*/})}
    
    );

    }

     // Creating RestAPI 
     submitForm = (e)=>{
        e.preventDefault();
        alert("form is getting submitted ");
        console.log(this.state);

        const reqData = {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            },
            body:JSON.stringify({
                name: this.state.name,
                user: this.state.user,
                password: this.state.password,
                conpassword: this.state.conpassword,
                email: this.state.email ,
                contact: this.state.contact,
                address: this.state.address,
                city: this.state.city,
                pancard : this.state.pancard
                //consumer : this.state.consumer,

            })
        } 
        alert("Registered Successfull");
        fetch("http://localhost:8080/registercust",reqData)
        .then(resp => resp.json())
        .then(data => this.setState({customer:data , success : true }))

    }

    loginForm = ()=>{
        this.props.history.push("/Login");
    }

    render() {
        return (
            <div id="customerForm">
                <div className="container"><br />
                    <h1 className="text-success  text-center">Customer Registration Form </h1><br></br>

                    <div className="col-lg-8 m-auto d-block">

                        <form action="#" onsubmit="#" className="bg-light" >
                          <div className="form-group"></div>
                            <br></br>
                            <div className="form-group">
                                <label>Enter Name: </label>
                                <input type="text" name="name" className="form-control"  autoComplete="off" value={this.state.name} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.nameerror}</span>
                            </div>
                            <br></br>

                            <div class="form-group">
                                <label> Username: </label>
                                <input type="text" name="user" className="form-control" id="user" autoComplete="off" value={this.state.user} onChange={this.handleChange}/>
                                <span id="username" class="text-danger font-weight-bold">{this.state.errors.usererror}</span>
                             </div>
                             <br></br>

                             <div className="form-group">
                                <label> Password : </label>
                                <input type="password" name="password" className="form-control"  autoComplete="off" value={this.state.password} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.passworderror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Confirm Password : </label>
                                <input type="password" name="conpassword" className="form-control"  autoComplete="off" value={this.state.conpassword} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.conpassworderror}</span>
                            </div>
							<br></br>
                           
                            
                            <div className="form-group">
                                <label> Email : </label>
                                <input type="text" name="email" className="form-control"  autoComplete="off" value={this.state.email} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.emailerror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Contact Number : </label>
                                <input type="number" name="contact" className="form-control"  autoComplete="off" value={this.state.contact} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.contacterror}</span>
                            </div>
                            <br></br>
                           
                            <div className="form-group">
                                <label> Address: </label>
                                <input type="text" name="address" className="form-control"  autocomplete="off" value={this.state.address} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.addresserror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> City : </label>
                                <input type="text" name="city" className="form-control"  autocomplete="off" value={this.state.city} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.cityerror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Pancard Id : </label>
                                <input type="text" name="pancard" className="form-control"  autocomplete="off" value={this.state.pancard} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.pancarderror}</span>
                            </div>
                            <br></br>

                            {/* <div className="form-group">
                                <label> Consumer Number : </label>
                                <input type="number" name="consumer" className="form-control"  autocomplete="off" value={this.state.consumer} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.consumererror}</span>
                            </div>
                            <br></br> */}

                           
                            <br></br>
                            <input type="submit" name="submit" value="submit" className="btn btn-success" onClick={this.submitForm}  disabled={!this.state.formvalid}/>
                            <span>         </span>
                            <button className="btn btn-primary" onClick={this.loginForm} >Login</button> 
                            <br></br>
                            <br></br>
                            <br></br>
                        </form>
                        {/*<p style={{display:this.state.success?'block':'none'}}> Customer with  details had been saved {this.state.customer.cid}</p>*/}
                    </div>
                </div>
            </div>
        );
    }
}



