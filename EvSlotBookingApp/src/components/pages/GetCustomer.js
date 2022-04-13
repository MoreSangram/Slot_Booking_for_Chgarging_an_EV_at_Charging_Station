import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'

export default class GetCustomer extends Component {
    constructor(props)
    {
        super(props)
        this.state={

            error:null,
            customer:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/allcustomer")
        .then(resp => resp.json())
        .then(
            (result)=>{
                this.setState({
                    customer:result
                })
            },
            (error) => {
                this.setState({error})
            }
        )
    }


   
    render() {
        
        const {error ,customer} = this.state;
        if(error)
        {
            return
            (
                <div>Error: {error.message}</div>
            )
        }
        else
        {
            return (
                <div>
                 <br/>
                    <p className="text-center">  Customers will be displayed here using rest API </p>
                    <table className="table table-bordered table-striped  table-dark">
                    <thead className="thead-dark">

                        <tr >
                            <th colSpan="11">
                                <h3 align="center"> Customer Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th scope="col">Cid</th>
                            <th scope="col">Name</th>
                            <th scope="col">conpassword</th>
                            <th scope="col">Email</th>
                            <th scope="col">Contact</th>
                            <th scope="col">Address</th>
                            <th scope="col">City</th>
                            <th scope="col">Login_id</th>
                            <th scope="col">Pancard</th>
                            {/* <th scope ="col"> Consumer Number </th> */}
                            <th scope="col">Operation</th>    
                        </tr>
                    </thead>
                    <tbody>
                    {customer.map(obj =>(
                             <tr >
                                <td> {obj.cid} </td>
                                <td> {obj.name} </td>
                                <td> {obj.conpassword}</td>
                                <td> {obj.email} </td>
                                <td> {obj.contact} </td>
                                <td> {obj.address} </td>
                                <td> {obj.city}   </td>
                                <td> {obj.login_tbl.login_id} </td>
                                <td> {obj.pancard} </td>
                                {/* <td> {obj.consumer} </td> */}
                                <td> <Button varient="info" onClick={()=>this.props.editCustomer(obj.cid)}>Delete</Button></td>
                             </tr>

                        ))}
                        </tbody>
                    </table>
                </div>
            )
        }
    }
}