myApp.directive("greet", function() {
   return {
       scope: {
           userObj : "=user"
       },
       template : "Hello {{userObj.name}}, your age is {{userObj.age}}"
   }
});
