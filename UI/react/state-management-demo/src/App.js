import React from 'react';
import useRandomNumber from './useRandomNumber';
import './App.css';

function App() {
  const number = useRandomNumber();

  return (
    <div className="App">
      <h1>State Management Demo</h1>
      <p>Random number: {number}</p>
    </div>
  );
}

export default App;