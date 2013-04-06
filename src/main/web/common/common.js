// JavaScript Document

function popwin(pagename){
window.open(pagename,"","resizable=yes,location=no,scrollbars=auto,toolbar=no,menubar=no,directories=no,width=3,height=3");
}


function noLink() { }

// for setting a hidden property ('submitValue') from a submit button
function setSubmit(target) {
     document.forms[0].submitValue.value=target;
};

