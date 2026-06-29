export function LoadingState() {
  return (
    <section className="loadingState" aria-live="polite">
      <div className="loader" aria-hidden="true" />
      <p>Loading movies...</p>
    </section>
  );
}

export function Notice({ message, tone = "info", onRetry }) {
  if (!message) {
    return null;
  }

  return (
    <section className={`notice ${tone}`} role={tone === "error" ? "alert" : "status"}>
      <p>{message}</p>
      {onRetry ? (
        <button type="button" onClick={onRetry}>
          Retry
        </button>
      ) : null}
    </section>
  );
}
