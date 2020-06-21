

function pricePerUnit(setupCost, incrementalCost, qty) {
	return (setupCost / qty) + incrementalCost;
}

function isNumber(x) {
	var v = x.trim();
	return (v.length > 0 && !isNaN(x));
}

function getMinQty(setupCost, incrementalCost) {
	var low = Math.round(setupCost / incrementalCost);
	var stump = Math.log10(low);
	var floorStump = Math.floor(stump);
	var retval = Math.pow(10, floorStump);
	return retval;
}

function getQuantities(setupCost, incrementalCost) {
	var min = getMinQty(setupCost, incrementalCost);
	var retvals = [];
	for (var i = 1; i <= 25; i++) {
		retvals.push(min * i)
	}
	return retvals;
}

function graphitClicked() {
	alert("graphIt clicked");
	var elementName = "graph";
	var setupCost = document.getElementById("setupCost").value;
	var incrementalCost = document.getElementById("incrementalCost").value;
	alert("elementName " + elementName + " setupCost " + setupCost + " incrementalCost " + incrementalCost);
	graphIt(elementName,Number(setupCost),Number(incrementalCost));
}

function graphIt(element, setupCost, incrementalCost) {
	// element id of div to contain graph
	// setupCost, incrementalCost numbers
	alert ("element " + element + " setupCost " + setupCost + " incrementalCost " + incrementalCost);
		var xValues = getQuantities(setupCost, incrementalCost);
		var yValues = []
		for (var i = 0; i < xValues.length; i++) {
			qty = xValues[i];
			yValues.push(pricePerUnit(setupCost, incrementalCost, qty));
		}
		graph = document.getElementById(element);
		Plotly.plot(graph, [ {
			x : xValues,
			y : yValues
		} ], {
			margin : {
				t : 0
			}
		});
}
