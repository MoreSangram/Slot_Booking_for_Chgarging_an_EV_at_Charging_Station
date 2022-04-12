import React from "react";
export default class AboutUs extends React.Component {
    render() {
        return (
            <div>
                <div className="about-section"  >
                    <h1 style={{textAlign:"center",color:"yellowgreen"}}>About Us </h1>
                    <div style={{textAlign:"center"}}>
                        <p>Some text about who we are and what we do .
                            Resize the browser window to see that this page is responsive by the way.</p>
                    <div/>
                </div>
            </div>
            <br/>
            <div>
            <img  src="./images/ucopy2.jpg"  style={{width:"100%"}}/>
            </div>


                {/* <h2 style={{textAlign:"center"}}>Our Team</h2>
                <div className="row" >
                    <div className="column"  >
                        <div className="card" style={{textAlign:"center"}}>
                            <div className="img" >
                                <img  src="./images/photo.jpg" alt="Ruman" style={{width:"15%", ttexAlign:"center"}}/>
                            </div>
                            <div class ="container">
                            <h2>sushant joshi</h2>
                            <p className ="title" class="text-info" style={{fontSize:"25px"}}>CEO and Founder</p>
                            <p>Team Leader </p>
                            <p>sushantjoshi500@gmail.com</p>
                            <p>Mob:+917588855249</p>
                        </div>
                    </div>
                </div>

                    <div className="column">
                        <div className="card" style={{textAlign:"center"}}>
                            <div className="img" >
                                <img src="./images/Anant.jpeg"  alt="Anant" style={{width:"15%", textAlign:"center"}}/>
                            </div>
                            <div className ="container">
                            <h2>Anant Marpalle</h2>
                            <p className ="title" class="text-info" style={{fontSize:"25px"}} >Developer</p>
                            <p>Full Stack Developer</p>
                            <p>marpalleanant1998@gmail.com</p>
                            <p>Mob:+917030308617</p>
                        </div>
                    </div>
                </div> */}

                   

                    
                </div>

            // </div>
        );
    }
}