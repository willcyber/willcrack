// Define translate function in global scope immediately
var translate = function translate() {
	try {
		// Get input and output languages
		var ciphertype = document.getElementById("ciphertype").value;
		var eord = document.getElementById("eord").value;

		// Get input text
		var inputText = document.getElementById("input-text").value;

		// Translate input text to output language
		var outputText = "";
		
		if (ciphertype == "caesar") {
			if (eord == "decrypt") {
				// Decrypt: shift back by 3 (subtract 3)
				for (var i = 0; i < inputText.length; i++) {
					var c = inputText.charCodeAt(i);
					if (c >= 65 && c <= 90) {  // uppercase letter
						c = (c - 65 - 3 + 26) % 26 + 65;
						outputText += String.fromCharCode(c);
					} else if (c >= 97 && c <= 122) {  // lowercase letter
						c = (c - 97 - 3 + 26) % 26 + 97;
						outputText += String.fromCharCode(c);
					} else {
						// Preserve non-letter characters
						outputText += inputText.charAt(i);
					}
				}
			} else if (eord == "encrypt") {
				// Encrypt: shift forward by 3 (add 3)
				for (var i = 0; i < inputText.length; i++) {
					var c = inputText.charCodeAt(i);
					if (c >= 65 && c <= 90) {  // uppercase letter
						c = (c - 65 + 3) % 26 + 65;
						outputText += String.fromCharCode(c);
					} else if (c >= 97 && c <= 122) {  // lowercase letter
						c = (c - 97 + 3) % 26 + 97;
						outputText += String.fromCharCode(c);
					} else {
						// Preserve non-letter characters
						outputText += inputText.charAt(i);
					}
				}
			}
		} else if (ciphertype == "atbash") {
			// Atbash: same for encrypt and decrypt (reverses alphabet)
			for (var i = 0; i < inputText.length; i++) {
				var c = inputText.charCodeAt(i);
				if (c >= 65 && c <= 90) {  // uppercase letter
					c = (25 - (c - 65)) % 26 + 65;
					outputText += String.fromCharCode(c);
				} else if (c >= 97 && c <= 122) {  // lowercase letter
					c = (25 - (c - 97)) % 26 + 97;
					outputText += String.fromCharCode(c);
				} else {
					// Preserve non-letter characters
					outputText += inputText.charAt(i);
				}
			}
		} else if (ciphertype == "vigenere") {
			// Vigenère cipher: get key from input field
			var keyInput = document.getElementById("key");
			var keyRaw = keyInput ? keyInput.value.toLowerCase() : "key";
			// Filter key to only include letters
			var key = "";
			for (var k = 0; k < keyRaw.length; k++) {
				var keyChar = keyRaw.charCodeAt(k);
				if (keyChar >= 97 && keyChar <= 122) {  // lowercase letter
					key += keyRaw.charAt(k);
				}
			}
			if (key.length === 0) {
				key = "key"; // Default key if empty or no letters
			}
			
			var keyIndex = 0; // Track position in key
			
			if (eord == "decrypt") {
				// Decrypt: subtract key letter value
				for (var i = 0; i < inputText.length; i++) {
					var c = inputText.charCodeAt(i);
					if (c >= 65 && c <= 90) {  // uppercase letter
						var keyChar = key[keyIndex % key.length];
						var keyValue = keyChar.charCodeAt(0) - 97; // Convert to 0-25
						c = (c - 65 - keyValue + 26) % 26 + 65;
						outputText += String.fromCharCode(c);
						keyIndex++;
					} else if (c >= 97 && c <= 122) {  // lowercase letter
						var keyChar = key[keyIndex % key.length];
						var keyValue = keyChar.charCodeAt(0) - 97; // Convert to 0-25
						c = (c - 97 - keyValue + 26) % 26 + 97;
						outputText += String.fromCharCode(c);
						keyIndex++;
					} else {
						// Preserve non-letter characters (don't advance key index)
						outputText += inputText.charAt(i);
					}
				}
			} else if (eord == "encrypt") {
				// Encrypt: add key letter value
				for (var i = 0; i < inputText.length; i++) {
					var c = inputText.charCodeAt(i);
					if (c >= 65 && c <= 90) {  // uppercase letter
						var keyChar = key[keyIndex % key.length];
						var keyValue = keyChar.charCodeAt(0) - 97; // Convert to 0-25
						c = (c - 65 + keyValue) % 26 + 65;
						outputText += String.fromCharCode(c);
						keyIndex++;
					} else if (c >= 97 && c <= 122) {  // lowercase letter
						var keyChar = key[keyIndex % key.length];
						var keyValue = keyChar.charCodeAt(0) - 97; // Convert to 0-25
						c = (c - 97 + keyValue) % 26 + 97;
						outputText += String.fromCharCode(c);
						keyIndex++;
					} else {
						// Preserve non-letter characters (don't advance key index)
						outputText += inputText.charAt(i);
					}
				}
			}
		}
		
		// Set output text
		var outputElement = document.getElementById("output-text");
		if (outputElement) {
			outputElement.value = outputText;
		} else {
			console.error("Output element not found");
		}
	} catch (error) {
		console.error("Error in translate function:", error);
		alert("An error occurred: " + error.message);
	}
};

// Immediately assign to window to ensure global availability
if (typeof window !== 'undefined') {
	window.translate = translate;
	console.log('Translate function loaded and available');
} else {
	console.error('Window object not available');
}

// Set up event listener when DOM is ready
if (typeof document !== 'undefined') {
	if (document.readyState === 'loading') {
		document.addEventListener('DOMContentLoaded', setupTranslateButton);
	} else {
		// DOM is already loaded
		setupTranslateButton();
	}
}

function setupTranslateButton() {
	var btn = document.getElementById('translate-btn');
	if (btn) {
		btn.addEventListener('click', translate);
	} else {
		// Fallback: if button has onclick, that's fine too
		console.log('Translate button found, event listener attached');
	}
	
	// Set up cipher type change handler to show/hide key field
	var cipherTypeSelect = document.getElementById('ciphertype');
	var keyContainer = document.getElementById('key-container');
	
	if (cipherTypeSelect && keyContainer) {
		// Show/hide based on initial selection
		updateKeyFieldVisibility();
		
		// Add event listener for changes
		cipherTypeSelect.addEventListener('change', updateKeyFieldVisibility);
	}
}

function updateKeyFieldVisibility() {
	var cipherTypeSelect = document.getElementById('ciphertype');
	var keyContainer = document.getElementById('key-container');
	
	if (cipherTypeSelect && keyContainer) {
		if (cipherTypeSelect.value === 'vigenere') {
			keyContainer.style.display = 'block';
		} else {
			keyContainer.style.display = 'none';
		}
	}
}