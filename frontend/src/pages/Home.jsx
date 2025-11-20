import React,{useEffect,useState} from 'react'; import axios from '../api/axiosClient'; import ProductCard from '../components/ProductCard';
export default function Home(){ const [products,setProducts]=useState([]);
  useEffect(()=>{ axios.get('/api/public/products').then(r=>setProducts(r.data)).catch(()=>{}); },[]);
  const add = (p)=>{ const cart = JSON.parse(localStorage.getItem('cart')||'[]'); const idx = cart.findIndex(c=>c.id===p.id); if(idx>=0) cart[idx].quantity++; else cart.push({...p,quantity:1}); localStorage.setItem('cart',JSON.stringify(cart)); alert('Added'); };
  return (<div style={{padding:12}}><h2>Products</h2><div style={{display:'flex',gap:12,flexWrap:'wrap'}}>{products.map(p=><ProductCard key={p.id} product={p} onAdd={add}/>)}</div></div>);
}
