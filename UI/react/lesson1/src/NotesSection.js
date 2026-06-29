import React, { useState } from 'react';
import { produce } from 'immer';
import Notes from './Notes';

const initialData = [{ text: 'Hey' }, { text: 'There' }];

const NotesSection = () => {
  const [data, setData] = useState(initialData);

  const handleClick = () => {
    const text = document.querySelector('#noteinput').value.trim();
    if (text) {
      const nextState = produce(data, (draftState) => {
        draftState.push({ text });
      });
      document.querySelector('#noteinput').value = '';
      setData(nextState);
    }
  };

  return (
    <div>
      <h2>Notes App</h2>
      <input
        id="noteinput"
        style={{ width: '80%', marginRight: '8px' }}
        type="text"
        placeholder="Enter a new note"
      />
      <button onClick={handleClick}>Add note</button>
      <div style={{ marginTop: '12px' }}>
        <Notes data={data} />
      </div>
    </div>
  );
};

export default NotesSection;