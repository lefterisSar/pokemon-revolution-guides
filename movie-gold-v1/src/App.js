import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect } from "react";
import Layout from "./components/Layout";
import {Routes, Route} from 'react-router-dom';
import Home from "./components/home/Home";


function App() {

  const [bosses,setBosses] = useState([]);
  const getBosses= async ()=>
  {
    try
    {
      const response = await api.get("/api/bosses");
      setBosses(response.data)
      console.log(response.data)
    }
    catch (err){
      console.log(err,"WTF ? ")
    }
  }


  useEffect(()=>{
    getBosses();
  },[])



  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route path="/" element={<Home bosses={bosses}/>}/>
        </Route>
      </Routes>

    </div>
  );
}

export default App;
