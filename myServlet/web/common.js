

function sendRequest(method, uri, parameters) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, uri);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(`${parameters}`)
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            console.log(this.responseText)
        }
    }
}