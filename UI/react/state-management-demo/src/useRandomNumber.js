import { useReducer, useEffect } from 'react';

const reducer = (state, action) => {
  switch (action.type) {
    case 'SET_NUMBER':
      return { number: action.payload };
    default:
      return state;
  }
};

function useRandomNumber() {
  const [state, dispatch] = useReducer(reducer, { number: null });

  useEffect(() => {
    const intervalId = setInterval(() => {
      const number = Math.floor(Math.random() * 100) + 1;
      dispatch({ type: 'SET_NUMBER', payload: number });
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return state.number;
}

export default useRandomNumber;