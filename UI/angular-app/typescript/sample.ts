interface Task{
    name:String;
    status:String;
}

let obj = {} as Task;
obj.name= "Scanning";
obj.status = "In Progress";

console.log(obj.name + ' ' + obj.status);

