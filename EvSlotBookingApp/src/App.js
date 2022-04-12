import logo from './logo.svg';

import Home from './components/Home';
import {Helmet} from "react-helmet";
import {  Link, Route} from 'react-router-dom';
import Login from './components/Login';
import CustomerForm from './components/CustomerForm';
import DistributerForm from './components/DistributerForm';
import AboutUs from './components/AboutUs';



function App() {
  return (
    <div className="App">
         <Helmet>
                <meta charSet="utf-8" />
                <title>Slot booking for charging an EV</title>
                <link rel="canonical" href="http://mysite.com/example" />
                <meta name="description" content="Ev app test !" />
          </Helmet>
        
       <Home/>

    </div>
  );
}

export default App;
