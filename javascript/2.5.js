import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

const App = () => (
  <div className="container">
    <h1>Hello Styled World</h1>
  </div>
);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);