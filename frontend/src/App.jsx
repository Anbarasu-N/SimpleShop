import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar.jsx';
import Footer from './components/Footer.jsx';
import ProtectedRoute from './components/ProtectedRoute.jsx';
import Home from './pages/Home.jsx';
import Products from './pages/Products.jsx';
import ProductDetails from './pages/ProductDetails.jsx';
import Categories from './pages/Categories.jsx';
import Cart from './pages/Cart.jsx';
import Checkout from './pages/Checkout.jsx';
import Login from './pages/Login.jsx';
import Register from './pages/Register.jsx';
import MyOrders from './pages/MyOrders.jsx';
import OrderDetails from './pages/OrderDetails.jsx';
import AdminDashboard from './pages/AdminDashboard.jsx';
import AdminProducts from './pages/AdminProducts.jsx';
import AddProduct from './pages/AddProduct.jsx';
import EditProduct from './pages/EditProduct.jsx';
import AdminCategories from './pages/AdminCategories.jsx';
import AdminOrders from './pages/AdminOrders.jsx';
import AdminOrderDetails from './pages/AdminOrderDetails.jsx';
import AdminUsers from './pages/AdminUsers.jsx';
export default function App(){return <><Navbar/><main className="container"><Routes>
<Route path="/" element={<Home/>}/><Route path="/products" element={<Products/>}/><Route path="/products/:id" element={<ProductDetails/>}/><Route path="/categories" element={<Categories/>}/><Route path="/cart" element={<Cart/>}/><Route path="/checkout" element={<ProtectedRoute><Checkout/></ProtectedRoute>}/>
<Route path="/login" element={<Login/>}/><Route path="/register" element={<Register/>}/><Route path="/orders" element={<ProtectedRoute><MyOrders/></ProtectedRoute>}/><Route path="/orders/:id" element={<ProtectedRoute><OrderDetails/></ProtectedRoute>}/>
<Route path="/admin" element={<ProtectedRoute admin><AdminDashboard/></ProtectedRoute>}/><Route path="/admin/products" element={<ProtectedRoute admin><AdminProducts/></ProtectedRoute>}/><Route path="/admin/products/new" element={<ProtectedRoute admin><AddProduct/></ProtectedRoute>}/><Route path="/admin/products/:id/edit" element={<ProtectedRoute admin><EditProduct/></ProtectedRoute>}/><Route path="/admin/categories" element={<ProtectedRoute admin><AdminCategories/></ProtectedRoute>}/><Route path="/admin/orders" element={<ProtectedRoute admin><AdminOrders/></ProtectedRoute>}/><Route path="/admin/orders/:id" element={<ProtectedRoute admin><AdminOrderDetails/></ProtectedRoute>}/><Route path="/admin/users" element={<ProtectedRoute admin><AdminUsers/></ProtectedRoute>}/>
<Route path="*" element={<h2>Page not found</h2>}/></Routes></main><Footer/></>;}
