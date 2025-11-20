import React,{useState} from 'react'; import axios from '../api/axiosClient'; import CheckoutForm from '../components/CheckoutForm';
export default function Cart(){ const [items,setItems]=useState(JSON.parse(localStorage.getItem('cart')||'[]')); const total = items.reduce((s,i)=>s + (i.price*i.quantity),0);
  const pay=async()=>{ const payload = items.map(i=>({productId:i.id,quantity:i.quantity})); const order = await axios.post('/api/orders/place', payload); const res = await axios.post('/api/payment/charge',{amount: order.amount}); if(res.data.status==='success'){ alert('Paid: '+res.data.transactionId); localStorage.removeItem('cart'); setItems([]); } };
  return (<div style={{padding:12}}><h3>Cart</h3>{items.map(it=>(<div key={it.id}>{it.name} x {it.quantity} - ₹{it.price}</div>))}<div><strong>Total: ₹{total}</strong></div><CheckoutForm onPay={pay} amount={total}/></div>);
}
