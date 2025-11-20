import React from 'react';
export default function CheckoutForm({onPay, amount}){ return (<div><h4>Total: ₹{amount}</h4><button onClick={onPay}>Pay</button></div>); }
