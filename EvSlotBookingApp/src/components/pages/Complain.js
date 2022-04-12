import React, { Component } from 'react'
import { Button } from 'react-bootstrap';

export default class Complain extends Component {

    constructor(props) {
        super(props);
        this.state={
            cid:"",
           complaint_date :"",
            // status: "",
            complaint_desc:"",
            complain :{},
            success:"false",
        }
    }

    handleChange=(e) =>{
        let nm = e.target.name;
        let val =e.target.value;
        this.setState({[nm]:val});

    }



       // creating Rest API 
       submitReq =(e)=>{
        e.preventDefault();
        console.log(this.state);

        const reqData = {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            },
            // given attribute must match exactly with the entity property !
            body:JSON.stringify({
                cid: this.state.cid,
               complaint_date  : this.state.complaint_date,
                // status : this.state.status,
                complaint_desc:this.state.complaint_desc
            })
        } ;

        fetch("http://localhost:8080/savecomplaint",reqData)
        .then(resp => resp.json())
        .then(data =>this.setState({complain:data , success : true }));
        alert("Complaint Raised");

    }


    render() {
        return (
            <div>

                <div className="container"><br />
                    <h1 className="text-danger  text-center" >Register Complain </h1><br></br>

                        <div className="col-lg-8 m-auto d-block">

                            <form onSubmit={this.submitReq} className="bg-light" id="complain">
                                <div className="form-group"></div>
                                    <br></br>
                                    <div className="form-group">
                                        <label>Customer ID: </label>
                                        <input type="text" name="cid" className="form-control"  autocomplete="off" value={this.state.cid} onChange={this.handleChange} />
                                    </div>
                                    <br></br>
                                    <div className="form-group">
                                        <label>Complaint Date: </label>
                                        <input type="date" name="complaint_date" className="form-control"  autocomplete="off" value={this.state.complaint_date} onChange={this.handleChange} />
                                    </div>
                                    
                                  {/*  <div className="form-group">
                                        <label> Status: </label>
                                        <div className="container p-2">
                                        <select className="custom-select">
                                            <option name="pending" value={this.state.pending}>Pending</option>
                                            <option  name="received" value={this.state.received }>Recived </option>
                                            <option  name ="cancel"  value={this.state. cancel }>Cancel</option>
                                        </select>
                                    </div>     
        </div>*/}
                                   {/* <br></br>
                                    <div className="form-group">
                                        <label>Status: </label>
                                        <input type="text" name="status" className="form-control"  autocomplete="off" value={this.state.status} onChange={this.handleChange} />
                                    </div>
                                    <br></br> */}
                                    <div className="form-group">
                                        <label>Complain Description :</label><br/><br/>
                                        <textarea name="complaint_desc" form="complain"   className="form-control" autoComplete="off" value={this.state.description} onChange={this.handleChange}>Enter text here...</textarea>
                                       
                                        {/*<input type="textarea" name=" description" className="form-control"  autocomplete="off" value={this.state.description} onChange={this.handleChange} />*/}
                                    </div>
                                    <br></br>
                                    <input type="submit"  value="Complaint" className="btn btn-success" /*onClick={this.submitReq}*/ />
                             </form>
                             <br/>

                             {/*
                             <p style={{display:this.state.success?'block':'none'}}> Customer with  details had been saved {this.state.complain.complain_id}</p>
                             */}

                         </div>
                    </div>    
            </div>
        )
    }
}
