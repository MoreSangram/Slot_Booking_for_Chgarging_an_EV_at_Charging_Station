import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter} from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import {Provider} from 'react-redux';
import mystore1 from './components/Store1';

ReactDOM.render(
  <React.StrictMode>


    <BrowserRouter>

        <Header/>
          <Provider store={mystore1}>
          <App />
          </Provider>
        <Footer/>


    </BrowserRouter>

  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
