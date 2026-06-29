export default function Header({ sourceLabel, totalMovies, visibleMovies }) {
  return (
    <header className="appHeader">
      <div>
        <p className="eyebrow">Movie Explorer</p>
        <h1>Streamify</h1>
      </div>

      <dl className="summaryStats" aria-label="Movie results summary">
        <div>
          <dt>Showing</dt>
          <dd>{visibleMovies}</dd>
        </div>
        <div>
          <dt>Total</dt>
          <dd>{totalMovies}</dd>
        </div>
        <div>
          <dt>Source</dt>
          <dd>{sourceLabel || "Loading"}</dd>
        </div>
      </dl>
    </header>
  );
}
