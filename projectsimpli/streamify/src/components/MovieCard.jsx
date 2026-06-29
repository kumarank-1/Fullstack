import { useState } from "react";

export default function MovieCard({ movie }) {
  const [imageFailed, setImageFailed] = useState(false);
  const initials = getInitials(movie.title);

  return (
    <article className="movieCard">
      <div className="posterFrame">
        {movie.poster && !imageFailed ? (
          <img
            src={movie.poster}
            alt={`${movie.title} poster`}
            loading="lazy"
            onError={() => setImageFailed(true)}
          />
        ) : (
          <div className="posterFallback" aria-label={`${movie.title} poster`}>
            <span>{initials}</span>
          </div>
        )}
      </div>

      <div className="movieInfo">
        <div className="movieTopline">
          <p>{movie.releaseYear}</p>
          <strong>{movie.rating.toFixed(1)}</strong>
        </div>

        <h2>{movie.title}</h2>
        <p className="overview">{movie.overview}</p>

        <ul className="genreList" aria-label={`${movie.title} genres`}>
          {movie.genres.map((genre) => (
            <li key={genre}>{genre}</li>
          ))}
        </ul>

        {movie.runtime ? (
          <p className="runtime">{formatRuntime(movie.runtime)}</p>
        ) : null}
      </div>
    </article>
  );
}

function getInitials(title) {
  return title
    .split(/\s+/)
    .filter(Boolean)
    .slice(0, 2)
    .map((word) => word[0])
    .join("")
    .toUpperCase();
}

function formatRuntime(minutes) {
  const hours = Math.floor(minutes / 60);
  const remainingMinutes = minutes % 60;

  if (!hours) {
    return `${remainingMinutes} min`;
  }

  return `${hours}h ${remainingMinutes}m`;
}
