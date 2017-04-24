function init() {

    setOnChangeConfiguration();
    initializeListeners();

}

function setOnChangeConfiguration() {
    $("#userName").change(updateName);
    $("#userAge").change(updateAge);
}

function initializeListeners() {
    emp.setListener('name', nameListener);
    emp.setListener('age', ageListener);
}

function nameListener() {
    $("#userName").val(emp.getValue('name'));
    console.log("Listener " + emp.getValue('name') + " " + emp.getValue('age'));
}
function ageListener() {
    $("#userAge").val(emp.getValue('age'));
    console.log("Listener " + emp.getValue('name') + " " + emp.getValue('age'));
}

function updateName() {
    emp.setValue('name', $("#userName").val());
}

function updateAge() {
    emp.setValue('age', $("#userAge").val());
}

function Employee() {
    var _data = {
        name:'',
        age:0
    };

    var _listeners = {
        name:null,
        age:null
    };

    this.getValue = function(attribute) {
        return _data[attribute];
    }

    this.setValue = function (attribute, value) {
        _data[attribute] = value;

        if (typeof _listeners[attribute] === 'function') {
            _listeners[attribute]();
        }

        console.log(emp);

    }

    this.setListener = function(attribute, listener) {
        _listeners[attribute] = listener;
    }
}

var emp = new Employee();