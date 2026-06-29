import React from 'react';

const Notes = (props) =>
  props.data.map((note, index) => <div key={index}>{note.text}</div>);

export default Notes;