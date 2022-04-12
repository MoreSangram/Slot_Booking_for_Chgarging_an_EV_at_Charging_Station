import React from 'react'

export default class OrderDetails extends React.Component {

    constructor(props)
    {
        super(props)
        this.state={
            history:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/getcust_orderdetails")
        .then(resp => resp.json())
        .then(data => {this.setState({history:data});
                                        alert(this.state.history.length)    })
    }



    render() {
        return (
            <div>
                <br/>
                <p className="text-center">Order Details will be displayed here using rest API </p>
                <table className="table table-bordered table-striped">
                    {
                      this.state.history.map(
                          obj =>{
                              return(
                                  <tr>
                                      <td> {obj.order_id} </td>
                                      <td> {obj.order_date} </td>
                                      <td> {obj.delivery_date} </td>
                                      <td> {obj.cylinder_no} </td>
                                      <td> {obj.status} </td>
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
