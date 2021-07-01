printjson(
  db.people
    .aggregate([
      { $match: {} },
      {
        $project: {
          newJob: { $substr: ["$job", 0, { $add: [{ $strLenCP: "$job" }] }] },
        },
      },
      {
        $group: {
          _id: "$newJob",
        },
      },
      { $sort: { _id: 1 } },
    ])
    .toArray()
);
