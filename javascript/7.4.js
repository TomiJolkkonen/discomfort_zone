import { FlatList, Text, View } from 'react-native';

const BookList = ({ books }) => (
  <FlatList
    data={books}
    keyExtractor={(item) => item.id}
    renderItem={({ item }) => (
      <View>
        <Text>{item.title}</Text>
        <Text>{item.author}</Text>
      </View>
    )}
  />
);

export default BookList;