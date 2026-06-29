import React, { useState } from 'react';
import Greetings from './Greetings';

function App() {
  const [name, setName] = useState('John');

  return (
    <div>
      <Greetings name={name} />
      <button onClick={() => setName('Jane')}>Change Name</button>
    </div>
  );
}

export default App;