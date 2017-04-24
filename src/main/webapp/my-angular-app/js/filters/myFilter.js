myApp.filter("adults", function() {
    return function(input) {
        var output = [];
        for (var i = 0; i < input.length; i++) {
            if (input[i].age >= 18) {
                output.push(input[i]);
            }
        }
        return output;
    }
});