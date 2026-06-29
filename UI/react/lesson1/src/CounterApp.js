import React from 'react';
import Number from './Number';

class CounterApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.onClick = this.onClick.bind(this);
  }

  onClick() {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  }

  render() {
    return (
      <div>
        <h2>Even Number Counter</h2>
        <Number number={this.state.count} />
        <button onClick={this.onClick}>Count</button>
      </div>
    );
  }
}

export default CounterApp;