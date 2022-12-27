function encrypt() {
    // Get the message from the text box
    var message = document.getElementById("message").value;

    // Shift each letter of the message by 3
    var encrypted = "";
    for (var i = 0; i < message.length; i++) {
        // Get the ASCII code of the current character
        var c = message.charCodeAt(i);

        // Shift the ASCII code by 3
        // If the character is a letter (uppercase or lowercase), wrap around if necessary
        if (c >= 65 && c <= 90) {  // uppercase letter
            c = (c - 65 + 3) % 26 + 65;
        } else if (c >= 97 && c <= 122) {  // lowercase letter
            c = (c - 97 + 3) % 26 + 97;
        }

        // Append the encrypted character to the encrypted message
        encrypted += String.fromCharCode(c);
    }

    // Update the HTML page with the encrypted message
    document.getElementById("encrypted").innerHTML = encrypted;
}