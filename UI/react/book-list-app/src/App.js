import React from 'react';

function BookList({ books }) {
  return (
    <ul>
      {books.map(book => (
        <li key={book.id}>
          <h3>{book.title}</h3>
          <p>by {book.author}</p>
        </li>
      ))}
    </ul>
  );
}

export default function App() {
  const books = [
    { id: 1, title: 'Book 1', author: 'Author 1' },
    { id: 2, title: 'Book 2', author: 'Author 2' },
    { id: 3, title: 'Book 3', author: 'Author 3' }
  ];

  return (
    <div>
      <h2>Book List</h2>
      <BookList books={books} />
    </div>
  );
}