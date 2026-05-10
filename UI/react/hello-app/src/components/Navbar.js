import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav style={{ display: "flex", gap: "12px", marginBottom: "20px" }}>
      <Link to="/">main</Link>
      <Link to="/home">Home</Link>
      <Link to="/products">Products</Link>
      <Link to="/users">Users</Link>
      <Link to="/login">Login</Link>
      <Link to="/logout">Logout</Link>
    </nav>
  );
}