import fs from "node:fs";
import path from "node:path";

const outputPath = path.resolve("docs", "Streamify_Project_Writeup.pdf");
const pageWidth = 612;
const pageHeight = 792;
const margin = 54;
const maxWidth = pageWidth - margin * 2;
const regularFont = "F1";
const boldFont = "F2";

const pages = [];
let commands = [];
let y = pageHeight - margin;

function startPage() {
  commands = [];
  y = pageHeight - margin;
  pages.push(commands);
}

function ensureSpace(height) {
  if (y - height < margin) {
    startPage();
  }
}

function escapePdfText(text) {
  return String(text)
    .replaceAll("\\", "\\\\")
    .replaceAll("(", "\\(")
    .replaceAll(")", "\\)");
}

function estimateWidth(text, size, font = regularFont) {
  const ratio = font === boldFont ? 0.55 : 0.51;
  return text.length * size * ratio;
}

function wrapText(text, size, font = regularFont) {
  const words = String(text).split(/\s+/).filter(Boolean);
  const lines = [];
  let current = "";

  words.forEach((word) => {
    const next = current ? `${current} ${word}` : word;

    if (estimateWidth(next, size, font) <= maxWidth) {
      current = next;
      return;
    }

    if (current) {
      lines.push(current);
    }

    current = word;
  });

  if (current) {
    lines.push(current);
  }

  return lines;
}

function textLine(text, options = {}) {
  const {
    size = 10,
    font = regularFont,
    x = margin,
    color = "0.10 0.13 0.16",
    leading = size + 5
  } = options;

  ensureSpace(leading);
  commands.push(`${color} rg`);
  commands.push(`BT /${font} ${size} Tf ${x} ${y} Td (${escapePdfText(text)}) Tj ET`);
  y -= leading;
}

function paragraph(text, options = {}) {
  const { size = 10.5, font = regularFont, gap = 11 } = options;
  const lines = wrapText(text, size, font);

  lines.forEach((line) => {
    textLine(line, { size, font, leading: size + 4 });
  });

  y -= gap;
}

function heading(text) {
  y -= 6;
  textLine(text, {
    size: 15,
    font: boldFont,
    color: "0.04 0.37 0.35",
    leading: 22
  });
  commands.push(
    `0.74 0.79 0.82 RG ${margin} ${y + 7} m ${margin + maxWidth} ${y + 7} l S`
  );
  y -= 4;
}

function smallLabel(text) {
  textLine(text.toUpperCase(), {
    size: 8.5,
    font: boldFont,
    color: "0.67 0.22 0.17",
    leading: 13
  });
}

function bullet(text) {
  const lines = wrapText(text, 10.2, regularFont);

  lines.forEach((line, index) => {
    textLine(`${index === 0 ? "-" : " "} ${line}`, {
      size: 10.2,
      x: index === 0 ? margin + 8 : margin + 18,
      leading: 14
    });
  });
}

function bulletList(items) {
  items.forEach(bullet);
  y -= 9;
}

function titlePage() {
  smallLabel("React Course End Project");
  textLine("Streamify", {
    size: 31,
    font: boldFont,
    color: "0.06 0.09 0.13",
    leading: 38
  });
  textLine("Movie Browsing and Search Application", {
    size: 15,
    font: boldFont,
    color: "0.19 0.25 0.30",
    leading: 24
  });
  y -= 8;
  paragraph(
    "Streamify is a React movie application that allows users to browse movies and filter them by title, genre, and rating. The application demonstrates practical React development concepts including functional components, hooks, props, event handling, conditional rendering, list rendering, API integration with Axios, loading states, and graceful error handling."
  );

  heading("Project Summary");
  bulletList([
    "Project name: Streamify",
    "Application type: Movie browsing and search app",
    "Frontend library: React",
    "Build tool: Vite",
    "HTTP client: Axios",
    "Movie data source: TMDb API when VITE_TMDB_API_KEY is configured, with a curated local fallback collection",
    "Primary users: People who want a quick way to discover and filter movies"
  ]);

  heading("Objective");
  paragraph(
    "The objective of this project is to build a simple and user-friendly movie app where users can search for films by title and narrow results using genre and rating filters. The app is designed to be clear, responsive, and reliable even when an external API is unavailable."
  );
}

function writeupPages() {
  heading("Key Features");
  bulletList([
    "Browse a collection of movie cards with poster, title, release year, rating, genres, overview, and runtime where available.",
    "Search movies instantly by typing a title into the search field.",
    "Filter movies by genre using a dropdown generated from the available movie data.",
    "Filter movies by minimum rating using a range input.",
    "Reset all active filters with a single button.",
    "Show a loading indicator while movie data is being fetched.",
    "Display friendly messages for API fallback, errors, empty results, and retry actions.",
    "Use responsive layout styles so the app works on desktop and mobile screens."
  ]);

  heading("React Concepts Used");
  bulletList([
    "Functional components are used for App, Header, SearchFilters, MovieGrid, MovieCard, and status messages.",
    "useState manages movie data, loading state, errors, selected genre, search text, and selected rating.",
    "useEffect loads movie data when the app first renders.",
    "useCallback keeps the movie-loading function stable when it is passed to retry logic.",
    "useMemo computes the available genre list and filtered movie results efficiently.",
    "Props pass data and event handlers from App into child components.",
    "Event handling is used in search input, select dropdown, rating slider, reset button, retry button, and image error handling.",
    "Conditional rendering displays loading, notices, errors, empty state, poster fallback, and runtime only when needed.",
    "List rendering is used for movie cards and genre tags."
  ]);

  heading("API Integration");
  paragraph(
    "The application uses Axios in src/services/movieApi.js. If VITE_TMDB_API_KEY is present in the .env file, Streamify calls the TMDb discover movie endpoint and normalizes the API response into the format used by the UI. If no key is configured, or if the API request fails, the app loads public/movies.json as a curated fallback data source."
  );
  paragraph(
    "This fallback approach keeps the user experience stable. Instead of breaking the interface when there is a network issue or an invalid API response, the app continues to show usable movie data and displays a notice explaining that the curated collection is being shown."
  );

  heading("Component Structure");
  bulletList([
    "App.jsx: Main container that loads data, stores state, computes filters, and passes props to child components.",
    "Header.jsx: Displays the application name, visible result count, total movie count, and active data source.",
    "SearchFilters.jsx: Contains the search box, genre dropdown, rating slider, and reset button.",
    "MovieGrid.jsx: Renders the list of movies or an empty state when no movie matches the filters.",
    "MovieCard.jsx: Displays movie details and handles poster image fallback when an image cannot load.",
    "StatusMessage.jsx: Provides reusable loading, notice, error, and retry UI.",
    "movieApi.js: Handles Axios requests, TMDb response normalization, fallback loading, and user-friendly API notices."
  ]);

  heading("State Management");
  paragraph(
    "The app keeps state management simple and local because the project scope is focused. The movie list, data source label, notice message, loading flag, error message, search term, selected genre, and minimum rating are all stored in App.jsx using the useState hook. Derived values such as the genre list and filtered results are calculated with useMemo."
  );

  heading("User Experience");
  bulletList([
    "The interface begins with the actual movie browsing tool rather than a landing page.",
    "The filter controls are placed at the top so users can quickly refine results.",
    "The result count updates as filters change, giving immediate feedback.",
    "The app avoids blank screens by showing loading, error, fallback, and empty-result states.",
    "Movie cards are compact and scannable, with key details visible at a glance.",
    "The layout adapts for smaller screens by stacking controls and cards cleanly."
  ]);

  heading("Setup and Run Steps");
  bulletList([
    "Open the streamify project folder.",
    "Install dependencies with npm.cmd install on Windows PowerShell if npm is blocked by script policy.",
    "Create a .env file and add VITE_TMDB_API_KEY=your_key to use TMDb.",
    "Start the development server with npm.cmd run dev.",
    "Open the local URL shown by Vite, normally http://127.0.0.1:5173/.",
    "Build the production version with npm.cmd run build."
  ]);

  heading("Error Handling");
  paragraph(
    "The app handles API problems gracefully. If TMDb returns an error status, if the request cannot reach the server, or if another request failure occurs, Streamify catches the error and loads local movie data instead. When a full data load fails, the user sees a clear error message and a retry button."
  );

  heading("Conclusion");
  paragraph(
    "Streamify satisfies the project goal by providing a simple React movie app with title search, genre filtering, rating filtering, Axios API integration, loading feedback, and graceful API error handling. The project uses core React concepts in a clean component structure and remains easy to extend with additional features such as favorites, pagination, detailed movie pages, or advanced sorting."
  );
}

function buildPdf() {
  startPage();
  titlePage();
  writeupPages();

  const objects = [];
  const fontObjectStart = 3 + pages.length * 2;
  const regularFontObject = fontObjectStart;
  const boldFontObject = fontObjectStart + 1;
  const pageObjectNumbers = [];
  const contentObjectNumbers = [];

  pages.forEach((_, index) => {
    pageObjectNumbers.push(3 + index * 2);
    contentObjectNumbers.push(4 + index * 2);
  });

  objects[1] = "<< /Type /Catalog /Pages 2 0 R >>";
  objects[2] = `<< /Type /Pages /Kids [${pageObjectNumbers
    .map((number) => `${number} 0 R`)
    .join(" ")}] /Count ${pages.length} >>`;

  pages.forEach((pageCommands, index) => {
    const content = `${pageCommands.join("\n")}\n`;
    const pageNumber = pageObjectNumbers[index];
    const contentNumber = contentObjectNumbers[index];

    objects[pageNumber] =
      `<< /Type /Page /Parent 2 0 R /MediaBox [0 0 ${pageWidth} ${pageHeight}] ` +
      `/Resources << /Font << /${regularFont} ${regularFontObject} 0 R /${boldFont} ${boldFontObject} 0 R >> >> ` +
      `/Contents ${contentNumber} 0 R >>`;
    objects[contentNumber] = `<< /Length ${Buffer.byteLength(
      content,
      "utf8"
    )} >>\nstream\n${content}endstream`;
  });

  objects[regularFontObject] =
    "<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>";
  objects[boldFontObject] =
    "<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica-Bold >>";

  let pdf = "%PDF-1.4\n";
  const offsets = [0];

  for (let index = 1; index < objects.length; index += 1) {
    offsets[index] = Buffer.byteLength(pdf, "utf8");
    pdf += `${index} 0 obj\n${objects[index]}\nendobj\n`;
  }

  const xrefOffset = Buffer.byteLength(pdf, "utf8");
  pdf += `xref\n0 ${objects.length}\n`;
  pdf += "0000000000 65535 f \n";

  for (let index = 1; index < objects.length; index += 1) {
    pdf += `${String(offsets[index]).padStart(10, "0")} 00000 n \n`;
  }

  pdf += `trailer\n<< /Size ${objects.length} /Root 1 0 R >>\nstartxref\n${xrefOffset}\n%%EOF\n`;

  fs.writeFileSync(outputPath, pdf);
}

buildPdf();
console.log(`Created ${outputPath}`);
