import React, { Fragment } from 'react'
import { connect } from 'react-redux';
import Imagen from './imagen';
const Result = (props) => {
  
  return <Fragment>
      <Imagen url = {props.result} />
  </Fragment>
}


const stateMapToPros = state => {
  return {
    result: state.random.result?.resultado
  }
}


export default connect(stateMapToPros)(Result)
