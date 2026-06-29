import React, { memo } from 'react';

const Greetings = memo(({ name }) => {
  console.log('Rendering Greetings');
  return <div>Hello, {name}!</div>;
});

export default Greetings;