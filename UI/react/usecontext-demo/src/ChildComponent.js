import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function ChildComponent() {
  const theme = useContext(ThemeContext);
  return <p>Current Theme: {theme}</p>;
}

export default ChildComponent;