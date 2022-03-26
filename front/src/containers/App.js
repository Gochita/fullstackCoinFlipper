import React, { Component, Fragment } from "react";
import From from "../components/From";
import Result from "../components/Result";

class App extends Component {
  // component stateful
  render() {
    return (
      <Fragment>
        <center>
          <h3>COIN FLIPPER</h3>
          <p>Flip a coin! Good luck</p>
          <From />
          <br />
          <Result />
        </center>
      </Fragment>
    );
  }
}

export default App;
