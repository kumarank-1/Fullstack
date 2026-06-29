import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import ChildComponent from './ChildComponent';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  document.body.style.backgroundColor = theme === 'dark' ? 'black' : 'white';
  document.body.style.color = theme === 'dark' ? 'white' : 'black';

  return (
    <div>
      <ThemeContext.Provider value={theme}>
        <h1>App</h1>
        <button onClick={toggleTheme}>Toggle Theme</button>
        <ChildComponent />
      </ThemeContext.Provider>
    </div>
  );
}

export default App;