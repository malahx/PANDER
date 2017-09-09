fetch('http://localhost:8080/candidate/20').then(function(response) {
  return response;
}).then(function(myBlob) {
	var ul = document.getElementById("ul");
	  console.log(myBlob);
  var candidates = JSON.parse(myBlob);
  for (let candidate of candidates) {
	var li = document.createElement("li");
	li.innerHTML = candidate.name;
	ul.append(il);
  }
});