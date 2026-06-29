import React, { useState } from 'react';

function WeatherForm({ onSubmit }) {
  const [city, setCity] = useState('');

  const handleSubmit = e => {
    e.preventDefault();
    if (!city.trim()) return;
    onSubmit(city);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        value={city}
        onChange={e => setCity(e.target.value)}
        placeholder="Enter city"
      />
      <button type="submit">Get Weather</button>
    </form>
  );
}

export default WeatherForm;