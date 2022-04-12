import React from "react";
import  "../App.css";

function Footer(){

    const currentYear = new Date().getFullYear();
    return (
       
        <footer>
            <h3>Copyright @ ISO {currentYear}</h3>
        </footer>
     );
}
export default Footer;