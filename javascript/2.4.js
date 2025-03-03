import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom/client';
import axios from 'axios';

const App = () => {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:3001/notes')
      .then(response => setNotes(response.data));
  }, []);

  const toggleImportance = id => {
    const note = notes.find(n => n.id === id);
    const changedNote = { ...note, important: !note.important };

    axios.put(`http://localhost:3001/notes/${id}`, changedNote)
      .then(response => {
        setNotes(notes.map(n => n.id !== id ? n : response.data));
      });
  };

  return (
    <div>
      <h1>Notes</h1>
      <ul>
        {notes.map(note =>
          <li key={note.id}>
            {note.content}
            <button onClick={() => toggleImportance(note.id)}>
              {note.important ? 'make not important' : 'make important'}
            </button>
          </li>
        )}
      </ul>
    </div>
  );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);