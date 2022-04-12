import React, { Component } from 'react'
import BookDistributer from './BookDistributer';
export default class BookSlot extends Component {
    constructor(props) {
        super(props);
        this.state={
            book_date:"",
            stationName:"",
            amount:"100",
            startTime:"",
            endTime:"",
            vid:"",
            payment_mode:"Cash",
               // cod:"",
               // netbanking:"",
              //  upi_id:""
           // },
           
           // cod:"",
            //netbanking:"",
            //upi_id:"",
            distributor:[],
            book:{},
            success:"false"
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
        //console.log(this.state);

        const reqData = {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json'
            },
            // given attribute must match exactly with the entity property !
            body:JSON.stringify({
                book_date: this.state.book_date,
                stationName : this.state.stationName,
                amount: this.state.amount,
                startTime: this.state.startTime,
                endTime: this.state.endTime,
                vid:this.state.vid,
                payment_mode:this.state.payment_mode
               

            })
        } ;
        

        fetch("http://localhost:8080/savebook",reqData)
        .then(resp => resp.json())
        .then(data =>this.setState({book:data , success : true}));
        alert("Booking Confirm");
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
            <div >
                <BookDistributer/>
                   <div className="container"><br />
                    <h1 className="text-success
                      text-center">Book Slot </h1><br></br>

                    <div className="col-lg-8 m-auto d-block">

                        <form onSubmit={this.submitReq} className="bg-light" >
                          <div className="form-group"></div>
                            <br></br>
                            <div className="form-group">
                                <label>Booking Date: </label>
                                <input type="date" name="book_date" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label>Enter Charging Station Name :</label>
                                {/* <select>
                                {distributor.map((obj)=>(
                                    <option value={obj.d_id} name="stationName" onChange={this.handleChange}>{obj.name}</option>
                                ))}</select> */}
                                <input type="text" name="stationName" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                            </div>
                            <br></br>

                            <div class="form-group">
                                <label> Amount : </label>
                                <input type="number" placeholder='100' name="amount" class="form-control"  autocomplete="off" value={this.state.amount} onChange={this.handleChange} />
                             </div>
                             <br></br>

                             <div className="form-group">
                                <label> charging start time </label>
                                <input type="time" name="startTime" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                                
                            </div>

                            <div className="form-group">
                                <label> charging end time </label>
                                <input type="time" name="endTime" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                                
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Vehicle No.: </label>
                                <input type="text" name="vid" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                            </div>
                            <br></br>
                            <div className="form-group">
                                <label> Payment Mode: </label>
                                <input type="text" placeholder='Cash' value={'Cash'} name="payment_mode" className="form-control"  autocomplete="off" onChange={this.handleChange} />
                           </div>
                            <br></br>

{/* this must be dynamically fect from the database or sever side if u know how to do it plz do this !
                             <div className="form-group">
                                <label>Actual Delivery Date: </label>
                                <input type="date" name="actual_date" className="form-control"  autocomplete="off" />
                            </div>
                            <br></br>


                            <div className="form-group">
                                <label>Payment Methode: </label>
                                    <div className="container p-3">
                                        <select className="custom-select">
                                            <option name="cod" value={this.state.cod}>Cod</option>
                                            <option  name="netbanking" value={this.state.netbanking}>Net Banking </option>
                                            <option  name ="upi_id"  value={this.state.upi_id}> UPI Id </option>
                                        </select>
                                        <br/>
                                        <br/>
                                        <button className="btn btn-primary">Payment Link</button>
                                    </div>
                            </div>
                            <br/>
                            <input type="submit" value="Book"/>*/}
                            <input type="submit"  value="book" className="btn btn-success" /*onClick={this.submitReq}*/ />
                        </form>
                        <br/>
                        {/*
                        <p style={{display:this.state.success ? 'block':'none'}}> Customer with  details had been saved {this.state.book.book_id}</p>
                        */}
                    </div>
                </div>   
            </div>
        );
    }
}
}
