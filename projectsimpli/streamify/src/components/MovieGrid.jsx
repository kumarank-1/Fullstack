import MovieCard from "./MovieCard";

export default function MovieGrid({ movies }) {
  if (!movies.length) {
    return (
      <section className="emptyState" aria-live="polite">
        <h2>No movies found</h2>
        <p>Try a different title, genre, or rating.</p>
      </section>
    );
  }

  return (
    <section className="movieGrid" aria-live="polite">
      {movies.map((movie) => (
        <MovieCard key={movie.id} movie={movie} />
      ))}
    </section>
  );
}
