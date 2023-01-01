function translate() {
	// Get input and output languages
	var ciphertype = document.getElementById("ciphertype").value;
	var eord = document.getElementById("eord").value;

	// Get input text
	var inputText = document.getElementById("input-text").value;

	// Translate input text to output language
	var outputText = "test";
	if (ciphertype == "caesar" && eord == "decrypt") {
        for (var i = 0; i < inputText.length; i++) {
            // Get the ASCII code of the current character
            var c = inputText.charCodeAt(i);
    
            // Shift the ASCII code by 3
            // If the character is a letter (uppercase or lowercase), wrap around if necessary
            if (c >= 65 && c <= 90) {  // uppercase letter
                c = (c - 65 + 3) % 26 + 65;
            } 
            else if (c >= 97 && c <= 122) {  // lowercase letter
                c = (c - 97 + 3) % 26 + 97;
            }
    
            // Append the encrypted character to the encrypted message
            outputText += String.fromCharCode(c);
        }
	} 
	// Set output text
	document.getElementById("output-text").value = outputText;
}