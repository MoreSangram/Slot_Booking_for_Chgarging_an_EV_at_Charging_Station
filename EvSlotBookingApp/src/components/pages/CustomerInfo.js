import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'

export default class CustomerInfo extends Component {

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
                    <p className="text-center">  </p>
                    <Table /*className="table table-bordered table-striped"*/>
                    <thead>

                        <tr>
                            <th colSpan={"1"}>
                                <h3> Customer Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th>Customer ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>Contact</th>
                            <th>Operation</th>
                                      
                        </tr>
                    </thead>
                    {customer.map(obj =>(
                             <tr >
                                <td> {obj.cid} </td>
                                <td> {obj.name} </td>
                                <td> {obj.email}</td>
                                <td> {obj.address} </td>
                                <td> {obj.city} </td>
                                <td> {obj.contact} </td>
                                
                                <td> <Button varient="info" onClick={()=>this.props.editCustomer(obj.cid)}>Edit</Button></td> 
                             </tr>

                        ))}
                    </Table>
                </div>
            )
        }
 
    }
}