import React from 'react';
import useFetch from './useFetch';
import './App.css';

function App() {
  const { data, error } = useFetch('https://jsonplaceholder.typicode.com/todos/1');

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  if (!data) {
    return <div>Loading...</div>;
  }

  return (
    <div className="App">
      <h1>Custom Hook Fetch Demo</h1>
      <p>Title: {data.title}</p>
      <p>Completed: {data.completed ? 'Yes' : 'No'}</p>
    </div>
  );
}

export default App;