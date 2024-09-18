import React from 'react';
import { Link } from 'react-router-dom';
import './Sidebar.css';

const Sidebar = () => (
  <div className="sidebar">
    <h2>Welcome User</h2>
    <ul>
      <li><Link to="/">Dashboard</Link></li>
      <li><Link to="/assessment">Create Assessment</Link></li>
      <li><Link to="/access">Access Management</Link></li>
    </ul>
  </div>
);

export default Sidebar;
