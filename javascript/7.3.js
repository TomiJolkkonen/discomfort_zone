import { useSubscription } from '@apollo/client';
import { BOOK_ADDED } from '../queries';

const useBookAdded = () => {
  useSubscription(BOOK_ADDED, {
    onData: ({ data }) => {
      const addedBook = data.data.bookAdded;
      console.log('New book added:', addedBook);
    },
  });
};

export default useBookAdded;