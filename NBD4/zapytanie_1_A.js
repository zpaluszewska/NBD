printjson(
  db.people
    .aggregate([
      { $match: {} },
      {
        $group: {
          _id: { $toLower: "$sex" },
          average_weight: { $avg: { $toDouble: "$weight" } },
          average_height: { $avg: { $toDouble: "$height" } },
        },
      },
    ])
    .toArray()
);
