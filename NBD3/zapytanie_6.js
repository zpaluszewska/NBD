db.people.insertOne({
  sex: "female",
  first_name: "Zaneta",
  last_name: "Paluszewska",
  job: "Analys",
  email: "s23905@pjwstk.edu.pl",
  location: {
    city: "Warszawa",
    address: { streetname: "Dolna", streetnumber: "10" },
  },
  description: "Ante nulla",
  height: "157",
  weight: "70",
  birth_date: "1997-06-17T01:01:01Z",
  nationality: "Poland",
  credit: {
    type: "switch",
    number: "9876543211234567890",
    currency: "PLN",
    balance: "1000.56",
  },
});
