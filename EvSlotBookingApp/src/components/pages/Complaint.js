import React, { Component } from 'react'

export default class Complaint extends Component {

    constructor(props)
    {
        super(props)
        this.state={
            complaint:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/allcomplaints")
        .then(resp => resp.json())
        .then(data => {this.setState({complaint:data});
                                       // alert(this.state.complaint.length)  
                                      })
    }

    render() {
        return (
            <div>
             <br/>
                <p className="text-center">  All Complaint Details   </p>
                <table className="table table-bordered table-striped">
                    <tr>
                        <th colSpan={"2"}>
                            <h3>All Complaints  Details</h3>
                        </th>      
                    </tr>
                    <tr>
                        <th>Complaints ID</th>
                        <th>Customer ID</th>
                        <th>Complaint Date</th>
                        {/* <th>Status</th>  */}
                        <th>Complaint Description</th>
                                    
                    </tr>
                    {
                      this.state.complaint.map(
                          obj =>{
                              return(
                                  <tr>
                                      <td> {obj.com_id} </td>
                                      <td> {obj.cid} </td>
                                      <td> {obj.complaint_date} </td>
                                      {/* <td> {obj.status} </td> */}
                                      <td>{obj.complaint_desc}</td>
                                     
                                  </tr>
                        
                              )
                          }
                      )
                    }

                </table>
            </div>
        )
    }
}
