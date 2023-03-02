import React, { useState } from "react";
import axios from "axios";

function LoginForm() {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleUserIdChange = (event) => {
    setUserId(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("/api/login", { userId, password });
      const userRole = response.data;
      if (userRole === "admin") {
        window.location.replace("/admin");
      }
      else if(userRole ==="seller"){
        window.location.replace("/seller");
      }
      else if(userRole ==="carpenter"){
        window.location.replace("/carpenter");
      }
      else if(userRole ==="customer"){
        window.location.replace("/customer");
      }
       else {
        // handle redirect to user page here
      }
    } catch (error) {
      setError(error.response.data);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
        <h3>Sign In</h3>
        <div className="mb-3">
          <label>User ID</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter email"
            value={userId} 
            onChange={handleUserIdChange}
          />
        </div>
        <div className="mb-3">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            placeholder="Enter password"

            value={password} 
            onChange={handlePasswordChange}
          />
        </div>
        <div className="d-grid">
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </div>
        <p className="forgot-password text-right">
        <a href="#">Forgot password?</a>
        </p>
      </form>

  );  
}

export default LoginForm;
