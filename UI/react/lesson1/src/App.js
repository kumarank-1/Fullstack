import React, { useState } from 'react';
import Bike from './Bike';
import MyList from './MyList';
import CounterApp from './CounterApp';
import NotesSection from './NotesSection';

function App() {
  const [activeSection, setActiveSection] = useState('firstapp');

  const items = [
    { id: 1, name: 'Pen' },
    { id: 2, name: 'Book' },
    { id: 3, name: 'Laptop' },
    { id: 4, name: 'Phone' }
  ];

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1>React Lessons Combined App</h1>

      <div style={{ display: 'flex', gap: '10px', flexWrap: 'wrap', marginBottom: '20px' }}>
        <button onClick={() => setActiveSection('firstapp')}>1. Class Component</button>
        <button onClick={() => setActiveSection('bike')}>2. Props & State</button>
        <button onClick={() => setActiveSection('mylist')}>3. Event Handler</button>
        <button onClick={() => setActiveSection('counter')}>4. Conditional Rendering</button>
        <button onClick={() => setActiveSection('notes')}>5. Notes Project</button>
      </div>

      <hr />

      <div style={{ marginTop: '20px' }}>
        {activeSection === 'bike' && <Bike />}
        {activeSection === 'mylist' && <MyList items={items} />}
        {activeSection === 'counter' && <CounterApp />}
        {activeSection === 'notes' && <NotesSection />}
      </div>
    </div>
  );
}

export default App;