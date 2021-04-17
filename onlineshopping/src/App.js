import React from 'react';

import './App.css';
import Test from "./Components/TestPage/Test";
import ComplexNavigationBar from "./Components/Common/ComplexNavigationBar/ComplexNavigationBar";
import LoggedHome from "./Components/LoggeHome/LoggedHome";
import Profile from "./Profile/Profile";
import Chat from "./Components/Test/Test";
import AdminHome from "./Components/Admin Panel/AdminHome";
import Product from "./Components/Product/Product";
import ProductsData from "./Components/Store Manager/ProductsData";
import DetailForm from "./Components/PaymentGateway/DetailForm";
import NonLoggedHome from "./Components/NonLoggedHome/NonLoggedHome";
import CheckoutForm from "./Components/PaymentGateway/CheckoutForm";
import ProductsTable from "./Components/Admin Panel/Tables/ProductsTable";


function App() {
  return (
    <div className="App">
       <Test/>
    </div>
  );
}

export default App;
