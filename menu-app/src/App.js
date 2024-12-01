import React from "react";
import MenuItemList from "./components/Menu";
import "bootstrap/dist/css/bootstrap.min.css";
import "font-awesome/css/font-awesome.min.css";
import "./App.css"; // Add custom styles here

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Restaurant Menu</h1>
      </header>
      <MenuItemList />
    </div>
  );
}

export default App;
