printjson(
  db.people
    .find(
      { birth_date: { $gte: "2000-01-01" } },
      { first_name: true, last_name: true, "location.city": true, _id: false }
    )
    .toArray()
);
