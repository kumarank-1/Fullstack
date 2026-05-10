// import { useRef, useState } from "react";

// function Counter() {
//   const [count, setCount] = useState(0);
//   const inputRef = useRef(null);

//   const focusInput = () => {
//     inputRef.current.focus();
//   };

//   return (
//     <div style={{ textAlign: "center", marginTop: "40px" }}>
//       <h1>Counter: {count}</h1>

//       <button onClick={() => setCount(count + 1)} style={{ marginRight: "10px" }}>
//         Increment
//       </button>

//       <button onClick={() => setCount(count - 1)} style={{ marginRight: "10px" }}>
//         Decrement
//       </button>

//       <button onClick={() => setCount(0)} style={{ marginRight: "10px" }}>
//         Reset
//       </button>

//       <hr style={{ margin: "20px 0" }} />

//       <input
//         ref={inputRef}
//         type="text"
//         placeholder="Type something..."
//         style={{ padding: "8px", marginRight: "10px" }}
//       />

//       <button onClick={focusInput}>Focus Input</button>
//     </div>
//   );
// }

// export default Counter;


import { useEffect, useRef, useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);
  const prevCountRef = useRef(0);

  useEffect(() => {
    prevCountRef.current = count;
  }, [count]);

  return (
    <div style={{ textAlign: "center", marginTop: "40px" }}>
      <h1>Current Count: {count}</h1>
      <h2>Previous Count: {prevCountRef.current}</h2>

      <button onClick={() => setCount((c) => c + 1)} style={{ marginRight: "10px" }}>
        Increment
      </button>

      <button onClick={() => setCount((c) => c - 1)} style={{ marginRight: "10px" }}>
        Decrement
      </button>

      <button onClick={() => setCount(0)} style={{ marginRight: "10px" }}>
        Reset
      </button>
    </div>
  );
}

export default Counter;