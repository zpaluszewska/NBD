var map = function () {
  var h = parseFloat(this.height);
  var w = parseFloat(this.weight);
  var value = {
    height: h,
    weight: w,
    count: 1,
  };

  var key = this.sex.toLowerCase();

  emit(key, value);
};

var reduce = function (key, values) {
  var result = {
    height: 0,
    weight: 0,
    count: 0,
  };

  for (var i = 0; i < values.length; i++) {
    result.height += values[i].height;
    result.weight += values[i].weight;
    result.count += values[i].count;
  }

  return result;
};

var fin = function (key, result) {
  endResult = {
    avg_height: 0,
    avg_weight: 0,
  };

  endResult.avg_height = result.height / result.count;
  endResult.avg_weight = result.weight / result.count;

  return endResult;
};

printjson(
  db.people.mapReduce(map, reduce, {
    out: { inline: 1 },
    finalize: fin,
  })
);
