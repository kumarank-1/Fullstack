import React from "react";
import Counter from "./features/counter/Counter.jsx";

function App() {
  return (
    <main className="app-shell">
      <section className="counter-panel" aria-labelledby="counter-title">
        <div className="counter-heading">
          <p className="eyebrow">React Redux</p>
          <h1 id="counter-title">Counter App</h1>
        </div>
        <Counter />
      </section>
    </main>
  );
}

export default App;
