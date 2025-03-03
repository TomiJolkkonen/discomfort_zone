import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Note from './Note';

test('renders content', () => {
  const note = {
    content: 'Component testing is done with react-testing-library',
    important: true
  };

  render(<Note note={note} />);
  expect(screen.getByText('Component testing is done with react-testing-library')).toBeDefined();
});