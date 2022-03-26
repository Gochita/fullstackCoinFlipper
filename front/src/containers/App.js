import React, { Component, Fragment } from "react";
import From from "../components/From";
import Result from "../components/Result";

class App extends Component {
  // component stateful


  render() {
    const estilo ={
      position:'absolute',
      right:'20px',
      bottom:'20px',
    }
    return (
      <Fragment>
        <center>
          <h3>COIN FLIPPER</h3>
          <p>Flip a coin! Good luck</p>
          <From />
          <br />
          <Result />
          <img style = {estilo} src={require('../img/signature.png').default}/>
        </center>
      </Fragment>
    );
  }
}

export default App;
