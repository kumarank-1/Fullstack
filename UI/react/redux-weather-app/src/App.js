import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchWeather } from './features/weatherSlice';
import WeatherForm from './WeatherForm';
import Weather from './Weather';

function App() {
  const dispatch = useDispatch();
  const { loading, weatherData, error } = useSelector(state => state.weather);

  const handleSubmit = city => {
    dispatch(fetchWeather(city));
  };

  return (
    <div>
      <h1>Weather App (Redux Toolkit)</h1>
      <WeatherForm onSubmit={handleSubmit} />
      <Weather loading={loading} weatherData={weatherData} error={error} />
    </div>
  );
}

export default App;