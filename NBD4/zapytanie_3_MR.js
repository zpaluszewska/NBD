var map = function () {
  var key = this.job;
  key = key.replace(" V", "");
  key = key.replace(" IV", "");
  key = key.replace(" III", "");
  key = key.replace(" II", "");
  key = key.replace(" I", "");

  values = "";
  emit(key, values);
};

var reduce = function (key, values) {
  values = "";
  return values;
};

printjson(db.people.mapReduce(map, reduce, { out: { inline: 1 } }));
