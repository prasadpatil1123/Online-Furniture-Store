import { Route, Routes } from 'react-router-dom';
import Navigation from './Components/NavBar/Navigation';
import LoginForm from './Components/LoginForm';
import Home from './Components/Home/Home';
import Admin from './Components/Admin';
import Seller from './Components/Seller';
import Carpenter from './Components/Carpenter';
import Customer from './Components/Customer';
import Products from './Components/Products';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

function App() {


  return (
    <>
    
    <Navigation/>

          
          <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/home' element={<Home/>}/>
            <Route path='/login' element={<LoginForm/>}/>
            <Route path='/admin' element={<Admin/>}/>
            <Route path='/seller' element={<Seller/>}/>
            <Route path='/carpenter' element={<Carpenter/>}/>
            <Route path='/customer' element={<Customer/>}/>
            <Route path='/products' element={<Products/>}/>
          
            

          </Routes>
          
    </>
  );
}



export default App;
