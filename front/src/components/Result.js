import React from 'react'
import { connect } from 'react-redux';
const Result = (props) => {
  
  return <div>
     {props.result && 'Resultado: '+ props.result} 
  </div>
}


const stateMapToPros = state => {
  return {
    result: state.random.result?.resultado
  }
}


export default connect(stateMapToPros)(Result)
