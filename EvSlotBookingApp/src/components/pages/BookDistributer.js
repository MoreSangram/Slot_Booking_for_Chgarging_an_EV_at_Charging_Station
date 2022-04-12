import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'

export default class BookDistributer extends Component {
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
                    <p className="text-center"> Available Charging Stations will be displayed here </p>
                    <table className="table table-bordered table-striped  table-white">
                    <thead className="thead-white">

                        <tr >
                            <th colSpan="11">
                                <h3 align="center"> Available Charging Station Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th scope="col">Distributor ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">City</th>
                            
                            
                           
                               
                        </tr>
                    </thead>
                    <tbody>
                    {distributor.map(obj =>(
                             <tr >
                                <td> {obj.d_id} </td>
                                <td> {obj.name} </td>
                                <td> {obj.address} </td>
                                <td> {obj.city}   </td>
                             </tr>

                        ))}
                        </tbody>
                    </table>
                </div>
            )
        }
    }
}