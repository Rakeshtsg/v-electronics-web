import React, {useState} from 'react'; import axios from '../api/axiosClient';
export default function Login(){ const [u,setU]=useState('demo'); const [p,setP]=useState('demo'); const [msg,setMsg]=useState('');
  const submit=async()=>{ try{ const r=await axios.post('/api/auth/login',{username:u,password:p}); if(r.data.token){ localStorage.setItem('token', r.data.token); setMsg('Logged in'); } else setMsg(JSON.stringify(r.data)); }catch(e){ setMsg('error'); } };
  return (<div style={{padding:12,marginBottom:12}}><input value={u} onChange={e=>setU(e.target.value)}/><input value={p} onChange={e=>setP(e.target.value)} type='password'/><button onClick={submit}>Login</button><small>{msg}</small></div>);
}
