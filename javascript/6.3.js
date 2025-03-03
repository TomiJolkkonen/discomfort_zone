import axios from 'axios';

const fetchNotes = async () => {
  const response = await axios.get('/api/notes');
  return response.data;
};

export const initializeNotes = () => {
  return async dispatch => {
    const notes = await fetchNotes();
    dispatch({
      type: 'INIT_NOTES',
      data: notes,
    });
  };
};