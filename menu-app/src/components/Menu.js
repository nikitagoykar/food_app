import React, { useEffect, useState } from "react";
import axios from "../services/axiosConfig";
import "./Menu.css"; // Add your custom CSS for styling

const Menu = () => {
  const [menuItems, setMenuItems] = useState([]);
  const [categories, setCategories] = useState([]);
  const [activeCategory, setActiveCategory] = useState("All");

  useEffect(() => {
    fetchMenuItems();
  }, []);

  const fetchMenuItems = async () => {
    try {
      const response = await axios.get("/menuItem");
      setMenuItems(response.data);

      // Extract unique categories from menu items
      const uniqueCategories = [
        "All",
        ...new Set(response.data.map((item) => item.category)),
      ];
      setCategories(uniqueCategories);
    } catch (err) {
      console.error("Error fetching menu items:", err);
    }
  };

  const filteredItems =
    activeCategory === "All"
      ? menuItems
      : menuItems.filter((item) => item.category === activeCategory);

  return (
    <div className="menu-section">
      <div className="container">
        <h1 className="text-center mb-5">Our Menu</h1>

        {/* Category Buttons */}
        <div className="text-center mb-4">
          {categories.map((category, index) => (
            <button
              key={index}
              className={`btn btn-outline-dark m-2 ${
                activeCategory === category ? "active" : ""
              }`}
              onClick={() => setActiveCategory(category)}
            >
              {category}
            </button>
          ))}
        </div>

        {/* Menu Items */}
        <div className="row">
          {filteredItems.length > 0 ? (
            filteredItems.map((item) => (
              <div className="col-md-4 mb-4" key={item.id}>
                <div className="card">
                  <img
                    src={item.imageUrl || "https://via.placeholder.com/150"}
                    className="card-img-top"
                    alt={item.name}
                  />
                  <div className="card-body">
                    <h5 className="card-title">{item.name}</h5>
                    <p className="card-text">{item.description}</p>
                    <p className="text-primary">${item.price.toFixed(2)}</p>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <div className="col-12">
              <p className="text-center">No items available for this category.</p>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default Menu;
