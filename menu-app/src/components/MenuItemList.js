import React, { useState, useEffect } from "react";
import axios from "../services/axiosConfig";

const MenuItemList = () => {
  const [menuItems, setMenuItems] = useState([]);
  const [category, setCategory] = useState("Dinner"); // Default category
  const [error, setError] = useState(null);

  // Fetch menu items by category
  const fetchMenuItems = async () => {
    try {
      const response = await axios.get(`/menuItem/category/${category}`);
      setMenuItems(response.data);
    } catch (err) {
      setError("Error fetching menu items. Please try again.");
    }
  };

  useEffect(() => {
    fetchMenuItems();
  }, [category]);

  return (
    <div className="menu-item-list">
      <h2>Menu Items</h2>
      <div>
        <label htmlFor="category">Choose a category:</label>
        <select
          id="category"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
        >
          <option value="Breakfast">Breakfast</option>
          <option value="Lunch">Lunch</option>
          <option value="Dinner">Dinner</option>
          <option value="Drinks">Drinks</option>
        </select>
      </div>

      {error && <p className="error">{error}</p>}

      {menuItems.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Category</th>
              <th>Description</th>
              <th>Price</th>
              <th>Image</th>
            </tr>
          </thead>
          <tbody>
            {menuItems.map((item) => (
              <tr key={item.id}>
                <td>{item.name}</td>
                <td>{item.category}</td>
                <td>{item.description}</td>
                <td>${item.price.toFixed(2)}</td>
                <td>
                  {item.imageUrl ? (
                    <img
                      src={item.imageUrl}
                      alt={item.name}
                      width="100"
                      height="80"
                    />
                  ) : (
                    "No Image"
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No menu items found for this category.</p>
      )}
    </div>
  );
};

export default MenuItemList;
