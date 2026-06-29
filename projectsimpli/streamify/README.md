# Streamify

Streamify is a React movie app for browsing and searching films by title, genre, and rating.

## Features

- React functional components with hooks and props
- Title search, genre filtering, and minimum rating filtering
- Axios movie data loading
- TMDb support through `VITE_TMDB_API_KEY`
- Curated local movie data when no API key is configured
- Loading, empty, and API error states

## Run Locally

```bash
npm install
npm run dev
```

To use TMDb, copy `.env.example` to `.env` and add your API key:

```bash
VITE_TMDB_API_KEY=your_key
```
