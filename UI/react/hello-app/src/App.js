import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar.js";
import Products from "./components/Products.js";
import User from "./components/User.js";
import Home from "./components/Home.js";
export default function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <Navbar />

        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/products" element={<Products />} />
          <Route path="/users" element={<User />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}