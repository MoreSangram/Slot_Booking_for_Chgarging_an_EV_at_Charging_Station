import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'

export default class GetDistributer extends Component {
    constructor(props)
    {
        super(props)
        this.state={

            error:null,
            distributor:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/alldistributor")
        .then(resp => resp.json())
        .then(
            (result)=>{
                this.setState({
                    distributor:result
                })
            },
            (error) => {
                this.setState({error})
            }
        )
    }


   
    render() {
        
        const {error ,distributor} = this.state;
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
                                <h3 align="center"> Distributor Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th scope="col">Distributor ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">conpassword</th>
                            <th scope="col">Email</th>
                            <th scope="col">Contact</th>
                            <th scope="col">Login_id</th>
                            <th scope="col">Pancard</th>
                            <th scope="col">Address</th>
                            <th scope="col">City</th>
                            <th scope="col">Operation</th>     
                        </tr>
                    </thead>
                    <tbody>
                    {distributor.map(obj =>(
                             <tr >
                                <td> {obj.d_id} </td>
                                <td> {obj.name} </td>
                                <td> {obj.conpassword}</td>
                                <td> {obj.email} </td>
                                <td> {obj.contact} </td>
                                <td> {obj.login_tbl.login_id} </td>
                                <td> {obj.pancard} </td>
                                <td> {obj.address} </td>
                                <td> {obj.city}   </td>
                               
                               
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