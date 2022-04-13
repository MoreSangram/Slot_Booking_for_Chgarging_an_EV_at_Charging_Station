import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'

export default class CustomerProfile extends Component {

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
                    <p className="text-center">  Customers will be displayed here </p>
                    <Table /*className="table table-bordered table-striped"*/>
                    <thead>

                        <tr>
                            <th colSpan={"1"}>
                                <h3> Customer Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th>Cid</th>
                            <th>Name</th>
                            <th>conpassword</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>Login_id</th>
                            <th>Pancard</th>
                            {/* <th>Consumer Number </th>   */}
                            <th>Operation</th>
                        </tr>
                    </thead>
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
                                <td> <Button varient="info" onClick={()=>this.props.editCustomer(obj.cid)}>Edit</Button></td>
                             </tr>

                        ))}
                    </Table>
                </div>
            )
        }
 
    }
}