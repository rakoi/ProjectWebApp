function getLecturer(e) {

    var name=document.getElementById('lectureNames').value;


    $('#lecturers').empty();

    if(name.length>0){
        fetch('http://localhost:8080/api/lecturer/'+name).then(
            function(response){
                return response.json();
            }).then(function(myJson){
            for(var i=0;i<myJson.length;i++){
                var li=document.createElement('li');
                var username=myJson[i].username;
                var url="<p onClick=\"getValue(this)\" >"+username+"</p>";
                li.innerHTML=url;
                li.classList.add("list-group-item");
                document.getElementById('lecturers').appendChild(li);

            }

        });
    }

}
function getValue(e){

    var username=e.innerHTML;

    document.getElementById('lectureNames').value=username;
    $('#lecturers').empty();
    document.getElementById('username').value=username;
}

function getUnit1(e) {

    var unit=document.getElementById('unit1').value;


    $('#unitslist').empty();

    if(unit.length>0){
        fetch('http://localhost:8080/api/lessons/'+unit).then(
            function(response){
                return response.json();
            }).then(function(myJson){
            for(var i=0;i<myJson.length;i++){
                var li=document.createElement('li');
                var lesson=myJson[i].name;
                var url="<p onClick=\"setUnit1(this)\" >"+lesson+"</p>";
                li.innerHTML=url;
                li.classList.add("list-group-item");
                document.getElementById('unitslist').appendChild(li);

            }

        });
    }

}
function setUnit1(e){

    var unit=e.innerHTML;

    document.getElementById('unit1').value=unit;
    $('#unitslist').empty();
}


// Unit 2

function getUnit2(e) {

    var unit=document.getElementById('unit2').value;


    $('#units2list').empty();

    if(unit.length>0){
        fetch('http://localhost:8080/api/lessons/'+unit).then(
            function(response){
                return response.json();
            }).then(function(myJson){
            for(var i=0;i<myJson.length;i++){
                var li=document.createElement('li');
                var lesson=myJson[i].name;
                var url="<p onClick=\"setUnit2(this)\" >"+lesson+"</p>";
                li.innerHTML=url;
                li.classList.add("list-group-item");
                document.getElementById('units2list').appendChild(li);

            }

        });
    }

}
function setUnit2(e){

    var unit=e.innerHTML;

    document.getElementById('unit2').value=unit;
    $('#units2list').empty();
}

// Unit 3

function getUnit3(e) {

    var unit=document.getElementById('unit3').value;


    $('#units3list').empty();

    if(unit.length>0){
        fetch('http://localhost:8080/api/lessons/'+unit).then(
            function(response){
                return response.json();
            }).then(function(myJson){
            for(var i=0;i<myJson.length;i++){
                var li=document.createElement('li');
                var lesson=myJson[i].name;
                var url="<p onClick=\"setUnit3(this)\" >"+lesson+"</p>";
                li.innerHTML=url;
                li.classList.add("list-group-item");
                document.getElementById('units3list').appendChild(li);

            }

        });
    }

}
function setUnit3(e){

    var unit=e.innerHTML;

    document.getElementById('unit3').value=unit;
    $('#units3list').empty();
}