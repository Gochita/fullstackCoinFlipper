import React from 'react'
import { useState , useEffect } from 'react';

const Imagen = ({url}) => {

  const [state, setState] = useState();
  
  useEffect( ()=>{
    
    switch(url){
      
      case('cruz'):
        setState("https://www.random.org/coins/faces/60-eur/italy-1euro/reverse.jpg")
        break
      
      case ('cara'):
        setState("https://www.random.org/coins/faces/60-eur/italy-1euro/obverse.jpg")
        break
    }
  }, [url] )


  return ( 
    <img src= {state} className="imagen" />
   );
}
 
export default Imagen;