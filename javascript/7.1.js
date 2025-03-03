import { gql } from '@apollo/client';

const ALL_BOOKS = gql\`
  query {
    allBooks {
      title
      author
      published
    }
  }
\`;

export default ALL_BOOKS;