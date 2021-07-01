printjson(
  db.people
    .aggregate([
      { $match: {} },
      { $unwind: "$credit" },
      {
        $group: {
          _id: { $toUpper: "$credit.currency" },
          balance: { $sum: { $toDouble: "$credit.balance" } },
        },
      },
    ])
    .toArray()
);
