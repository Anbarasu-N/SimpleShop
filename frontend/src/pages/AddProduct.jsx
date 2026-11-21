import {useNavigate} from 'react-router-dom';import api from '../services/api.js';import ProductForm from '../components/ProductForm.jsx';
export default function AddProduct(){const navigate=useNavigate();return <><h1>Add product</h1><ProductForm onSave={async data=>{await api.post('/products',data);navigate('/admin/products')}}/></>}
