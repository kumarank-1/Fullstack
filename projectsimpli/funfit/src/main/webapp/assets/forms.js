(function () {
    var params = new URLSearchParams(window.location.search);

    function fillFromQuery(name) {
        var element = document.querySelector("[name='" + name + "']");
        if (element && params.has(name)) {
            element.value = params.get(name);
        }
    }

    [
        "id",
        "batchName",
        "timeSlot",
        "instructorName",
        "capacity",
        "startTime",
        "endTime",
        "fullName",
        "email",
        "phone",
        "age",
        "gender",
        "batchId",
        "joinedDate"
    ].forEach(fillFromQuery);
})();
