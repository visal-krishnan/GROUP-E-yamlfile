import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React from 'react';
import Sidebar from './components/Sidebar';
import Dashboard from './components/Dashboard';
import CreateAssessment from './components/CreateAssessment';
import AccessManagement from './components/AccessManagement';
import NewAssessment from './components/NewAssessment';
import NewSet from './components/NewSet';
import './App.css';

const App = () => (
  <BrowserRouter>
    <div className="app">
      <Sidebar />
      <div className="main-content">
      <h1 className=" text-2xl font-bold ">Product IT Assessment</h1>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/assessment" element={<CreateAssessment />} />
          <Route path="/new-assessment" element={<NewAssessment />} />
          <Route path="/new-set" element={<NewSet />} />
          <Route path="/access" element={<AccessManagement />} />
        </Routes>
      </div>
    </div>
  </BrowserRouter>
);

export default App;
