import { useCallback, useEffect, useMemo, useState } from "react";
import Header from "./components/Header";
import MovieGrid from "./components/MovieGrid";
import SearchFilters from "./components/SearchFilters";
import { LoadingState, Notice } from "./components/StatusMessage";
import { fetchMovies } from "./services/movieApi";

const DEFAULT_GENRE = "All";
const DEFAULT_RATING = 0;

export default function App() {
  const [movies, setMovies] = useState([]);
  const [sourceLabel, setSourceLabel] = useState("");
  const [notice, setNotice] = useState("");
  const [isLoading, setIsLoading] = useState(true);
  const [loadError, setLoadError] = useState("");
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedGenre, setSelectedGenre] = useState(DEFAULT_GENRE);
  const [minimumRating, setMinimumRating] = useState(DEFAULT_RATING);

  const loadMovies = useCallback(async () => {
    setIsLoading(true);
    setLoadError("");
    setNotice("");

    try {
      const result = await fetchMovies();

      setMovies(result.movies);
      setSourceLabel(result.sourceLabel);
      setNotice(result.notice || "");
    } catch (error) {
      setMovies([]);
      setSourceLabel("");
      setLoadError(
        error.message || "Movie data could not be loaded. Please try again."
      );
    } finally {
      setIsLoading(false);
    }
  }, []);

  useEffect(() => {
    loadMovies();
  }, [loadMovies]);

  const genres = useMemo(() => {
    const uniqueGenres = new Set();

    movies.forEach((movie) => {
      movie.genres.forEach((genre) => uniqueGenres.add(genre));
    });

    return Array.from(uniqueGenres).sort();
  }, [movies]);

  const filteredMovies = useMemo(() => {
    const normalizedSearch = searchTerm.trim().toLowerCase();

    return movies.filter((movie) => {
      const matchesTitle = movie.title.toLowerCase().includes(normalizedSearch);
      const matchesGenre =
        selectedGenre === DEFAULT_GENRE || movie.genres.includes(selectedGenre);
      const matchesRating = movie.rating >= minimumRating;

      return matchesTitle && matchesGenre && matchesRating;
    });
  }, [minimumRating, movies, searchTerm, selectedGenre]);

  const hasActiveFilters =
    searchTerm !== "" ||
    selectedGenre !== DEFAULT_GENRE ||
    minimumRating !== DEFAULT_RATING;

  function resetFilters() {
    setSearchTerm("");
    setSelectedGenre(DEFAULT_GENRE);
    setMinimumRating(DEFAULT_RATING);
  }

  return (
    <main className="appShell">
      <Header
        sourceLabel={sourceLabel}
        totalMovies={movies.length}
        visibleMovies={filteredMovies.length}
      />

      <SearchFilters
        searchTerm={searchTerm}
        selectedGenre={selectedGenre}
        minimumRating={minimumRating}
        genres={genres}
        hasActiveFilters={hasActiveFilters}
        onSearchChange={setSearchTerm}
        onGenreChange={setSelectedGenre}
        onRatingChange={setMinimumRating}
        onReset={resetFilters}
      />

      <Notice message={notice} />
      <Notice message={loadError} tone="error" onRetry={loadMovies} />

      {isLoading ? <LoadingState /> : <MovieGrid movies={filteredMovies} />}
    </main>
  );
}
