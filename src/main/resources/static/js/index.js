function Send()
{


    var dni = document.getElementById("dni").value;
    if (dni) {
        window.location = '/index/' + dni;
}}
