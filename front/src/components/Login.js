import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const LoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = async (e) => {
    e.preventDefault();
    
    const response = await fetch('http://localhost:8081/test', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
      setLoggedIn(true);
    } else {
    }
  };

  return (
    <div className="form">
      {loggedIn ? (
        <div className="profile">
          <h2>Welcome, {username}!</h2>
          <p>Your password: {password}</p>
        </div>
      ) : (
        <form onSubmit={handleLogin}>
          <h2>Sign In</h2>
          <input 
            type="text" 
            value={username} 
            onChange={(e) => setUsername(e.target.value)} 
            placeholder="Username" 
            required 
          />
          <input 
            type="password" 
            value={password} 
            onChange={(e) => setPassword(e.target.value)} 
            placeholder="Password" 
            required 
          />
          <button type="submit">Login</button>
          <Link to="/register">Go to Register</Link>
        </form>
      )}
    </div>
  );
};

export default LoginPage;