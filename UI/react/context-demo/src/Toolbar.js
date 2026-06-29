import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const Toolbar = () => {
  const themeContext = useContext(ThemeContext);
  const { theme, toggleTheme } = themeContext;

  return (
    <div>
      <h2>Toolbar</h2>
      <button
        style={{
          backgroundColor: theme === 'light' ? '#ffffff' : '#000000',
          color: theme === 'light' ? '#000000' : '#ffffff',
          border: '1px solid #888',
          padding: '8px 12px',
          cursor: 'pointer'
        }}
        onClick={toggleTheme}
      >
        Change Theme
      </button>
      <p>Current Theme: {theme}</p>
    </div>
  );
};

export default Toolbar;