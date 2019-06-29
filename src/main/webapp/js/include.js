function zoomings(optionSel) {
    if (navigator.userAgent.indexOf("Firefox") != -1) {
        var OptionSelected = optionSel.selectedIndex;
        var optionT = document.getElementById("zooming");
        var len = optionT.options[OptionSelected].text.length - 1;
        var val = optionT.options[OptionSelected].text.substring(0, len) / 100;
        var div = document.getElementById("searches");
        var dd = "scale(" + val + ")";

        div.style.MozTransform = dd;
        div.style.MozTransformOrigin = "0 0";
    }
    else {
        var OptionSelected = optionSel.selectedIndex;
        var val = optionSel.options[OptionSelected].text;
        var div = document.getElementById("searches");
        div.style.zoom = val;
    }
}
function hideShowFunction() {
    var x = document.getElementById('myDIV');
    var y = document.getElementById('searches');
    if (x.style.display === 'none') {
        x.style.display = 'block';
        y.classList.remove('col-md-12');
        y.classList.add('col-md-9');
    } else {
        x.style.display = 'none';
        y.classList.remove('col-md-9');
        y.classList.add('col-md-12');
    }
}

function jump() {
    var x = document.getElementById('textbox').value;
    var top = document.getElementById(x).offsetTop;
    window.scrollTo(0,top);
}

function bookJump(h) {
    var top = document.getElementById(h).offsetTop;
    window.scrollTo(0,top);
}
function goTo() {
    var sel = document.getElementById('page');
    var val = sel.options[sel.selectedIndex].value;
    bookJump(val);
}

