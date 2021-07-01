var mapFun = function () {
  var temp = 0;

  for (var idx = 0; idx < this.credit.length; idx++) {
    temp = parseFloat(this.credit[idx].balance);

    var key = this.credit[idx].currency;
    var value = { balance: temp };
  }
  emit(key, value);
};

var reduceFun = function (key, values) {
  var result = {
    balance: 0,
  };

  for (var idx = 0; idx < values.length; idx++) {
    result.balance += values[idx].balance;
  }

  return result;
};

printjson(db.people.mapReduce(mapFun, reduceFun, { out: { inline: 1 } }));
