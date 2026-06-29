export default function SearchFilters({
  searchTerm,
  selectedGenre,
  minimumRating,
  genres,
  hasActiveFilters,
  onSearchChange,
  onGenreChange,
  onRatingChange,
  onReset
}) {
  return (
    <form className="filters" onSubmit={(event) => event.preventDefault()}>
      <label className="field titleField">
        <span>Title</span>
        <input
          type="search"
          value={searchTerm}
          onChange={(event) => onSearchChange(event.target.value)}
          placeholder="Search movies"
        />
      </label>

      <label className="field">
        <span>Genre</span>
        <select
          value={selectedGenre}
          onChange={(event) => onGenreChange(event.target.value)}
        >
          <option value="All">All genres</option>
          {genres.map((genre) => (
            <option key={genre} value={genre}>
              {genre}
            </option>
          ))}
        </select>
      </label>

      <label className="field ratingField">
        <span>Rating {minimumRating.toFixed(1)}+</span>
        <input
          type="range"
          min="0"
          max="10"
          step="0.5"
          value={minimumRating}
          onChange={(event) => onRatingChange(Number(event.target.value))}
        />
      </label>

      <button type="button" onClick={onReset} disabled={!hasActiveFilters}>
        Reset
      </button>
    </form>
  );
}
