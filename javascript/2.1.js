import React from 'react';
import ReactDOM from 'react-dom/client';

const Course = ({ course }) => (
  <div>
    <h1>{course.name}</h1>
    {course.parts.map(part => 
      <p key={part.id}>{part.name} {part.exercises}</p>
    )}
  </div>
);

const App = () => {
  const course = {
    name: 'Half Stack application development',
    parts: [
      { name: 'Fundamentals of React', exercises: 10, id: 1 },
      { name: 'Using props to pass data', exercises: 7, id: 2 },
      { name: 'State of a component', exercises: 14, id: 3 }
    ]
  };

  return <Course course={course} />;
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);