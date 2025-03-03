require('dotenv').config();
const mongoose = require('mongoose');

const url = process.env.MONGODB_URI;

mongoose.set('strictQuery', false);
mongoose.connect(url);

const personSchema = new mongoose.Schema({
  name: String,
  number: String,
});

const Person = mongoose.model('Person', personSchema);

const person = new Person({
  name: 'Ada Lovelace',
  number: '39-44-5323523',
});

person.save().then(result => {
  console.log('person saved!');
  mongoose.connection.close();
});