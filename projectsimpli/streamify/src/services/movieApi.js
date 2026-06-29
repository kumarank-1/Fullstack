import axios from "axios";
import { tmdbGenreMap } from "../data/genreMap";

const tmdbClient = axios.create({
  baseURL: "https://api.themoviedb.org/3",
  timeout: 10000
});

const localClient = axios.create({
  timeout: 6000
});

export async function fetchMovies() {
  const apiKey = import.meta.env.VITE_TMDB_API_KEY;

  if (!apiKey) {
    const movies = await loadCuratedMovies();

    return {
      movies,
      sourceLabel: "Curated collection"
    };
  }

  try {
    const response = await tmdbClient.get("/discover/movie", {
      params: {
        api_key: apiKey,
        include_adult: false,
        language: "en-US",
        page: 1,
        sort_by: "popularity.desc",
        "vote_count.gte": 500
      }
    });

    return {
      movies: normalizeTmdbMovies(response.data.results),
      sourceLabel: "TMDb API"
    };
  } catch (error) {
    const movies = await loadCuratedMovies();

    return {
      movies,
      sourceLabel: "Curated collection",
      notice: getApiNotice(error)
    };
  }
}

async function loadCuratedMovies() {
  const response = await localClient.get("/movies.json");
  const movies = response.data?.movies;

  if (!Array.isArray(movies)) {
    throw new Error("Movie data is unavailable. Please try again.");
  }

  return movies;
}

function normalizeTmdbMovies(results = []) {
  return results
    .filter((movie) => movie.title && movie.vote_average)
    .map((movie) => ({
      id: movie.id,
      title: movie.title,
      releaseYear: movie.release_date
        ? Number(movie.release_date.slice(0, 4))
        : "TBA",
      rating: Number(movie.vote_average.toFixed(1)),
      runtime: null,
      genres: movie.genre_ids
        .map((genreId) => tmdbGenreMap[genreId])
        .filter(Boolean),
      overview: movie.overview || "No overview is available for this movie.",
      poster: movie.poster_path
        ? `https://image.tmdb.org/t/p/w500${movie.poster_path}`
        : ""
    }));
}

function getApiNotice(error) {
  if (error.response) {
    return `Movie API returned status ${error.response.status}. Showing the curated collection instead.`;
  }

  if (error.request) {
    return "Movie API could not be reached. Showing the curated collection instead.";
  }

  return "Movie API request failed. Showing the curated collection instead.";
}
