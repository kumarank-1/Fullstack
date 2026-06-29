import React from 'react';
import useCounter from './useCounter';
import './App.css';

function App() {
  const { count, increment, decrement } = useCounter(0);

  return (
    <div className="App">
      <h1>Custom Hook Demo</h1>
      <p>Count: {count}</p>
      <button onClick={increment}>+</button>
      <button onClick={decrement}>-</button>
    </div>
  );
}

export default App;