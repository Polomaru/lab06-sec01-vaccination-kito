function sendForm()
{
    let json = {
        "dni": $('#dni').val(),
        "names": $('#names').val(),
        "surnames": $('#surnames').val(),
        "date": $('#date').val(),
        "phoneNum": $('#numero').val(),
        "email": $('#email').val()
    }
    try{
        $.ajax({
            url: 'http://localhost:8080/citizen/POST',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(json),
            dataType: 'json'
        })

    }catch (exception)
    {
        console.log(exception)
    }
}
