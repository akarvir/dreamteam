
function onloadfunction() {
var tags = document.getElementsByTagName("p");
var paragraph = tags[0];
var textnode = document.createTextNode("This is not really a paragraph");
paragraph.replaceChild(paragraph.firstChild,textnode); 
}