import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  decrement,
  increment,
  incrementByAmount,
  reset
} from "./counterSlice.js";

function Counter() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();
  const [amount, setAmount] = useState(5);

  const handleAmountChange = (event) => {
    setAmount(Number(event.target.value));
  };

  const handleAddAmount = () => {
    dispatch(incrementByAmount(amount));
  };

  return (
    <div className="counter">
      <div className="counter-display" aria-live="polite">
        <span className="counter-label">Current count</span>
        <strong>{count}</strong>
      </div>

      <div className="button-row" aria-label="Counter actions">
        <button type="button" onClick={() => dispatch(decrement())}>
          -1
        </button>
        <button type="button" className="primary-button" onClick={() => dispatch(increment())}>
          +1
        </button>
        <button type="button" onClick={() => dispatch(reset())}>
          Reset
        </button>
      </div>

      <div className="amount-control">
        <label htmlFor="amount">Custom amount</label>
        <div className="amount-row">
          <input
            id="amount"
            type="number"
            min="-100"
            max="100"
            value={amount}
            onChange={handleAmountChange}
          />
          <button type="button" onClick={handleAddAmount}>
            Add Amount
          </button>
        </div>
      </div>
    </div>
  );
}

export default Counter;
