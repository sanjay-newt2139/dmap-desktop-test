var numberformat = new Object ();

numberformat.keyPressIntegerOnly = function (myfield, e, dec)
{
    var key;
    var keychar;
    
    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);

    var ctrl = e.ctrlKey ? e.ctrlKey : ((key === 17) ? true : false);
    if ((key == 118 && ctrl) || (key == 99 && ctrl)) {
        return true;
    }

    if ((key==null) || (key==0) || (key==8) || 
        (key==9) || (key==13) || (key==27) )
       return true;

    else if ((("0123456789").indexOf(keychar) > -1))
       return true;

    else if (dec && (keychar == "."))
    {
    myfield.form.elements[dec].focus();
    return false;
    }
    else return false;
}

numberformat.keyPressDecimalOnly = function (myfield, e, dec)
{
    var key;
    var keychar;
    
    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);

    if ((key==null) || (key==0) || (key==8) || 
        (key==9) || (key==13) || (key==27) ) {
       return true;

    } else if ((("0123456789.").indexOf(keychar) > -1)) {
    	if (keychar == "." && myfield.value.indexOf(".") > -1) {
    		return false; 
    	} else {
       		return true;
       	}

    } else if (dec && (keychar == ".")) {
	    myfield.form.elements[dec].focus();
	    return false;
    } else return false;
}

numberformat.keyPressBuddhismYear = function (myfield, e, dec)
{
    var key;
    var keychar;

    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);

    if ((key==null) || (key==0) || (key==8) || 
        (key==9) || (key==13) || (key==27) )
       return true;

    else if ((("0123456789").indexOf(keychar) > -1))
       return true;

    else if (dec && (keychar == "."))
    {
    myfield.form.elements[dec].focus();
    return false;
    }
    else return false;
}

numberformat.addCommas = function (nStr)
{
	nStr += '';
	x = nStr.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
}

numberformat.removeComma = function (str) 
{
    return str.replace(/,/gi,"");
}

numberformat.removeUntilLastDot = function(str)
{
    var isFoundDot = false;
    var newString = "";
    for (var i = (str.length - 1); i >= 0; i--)
    {
        if (str.charAt(i) == '.')
        {
            if (!isFoundDot)
            {
                newString = str.charAt(i) + newString;
                isFoundDot = true;
            }
        }
        else
        {
            newString = str.charAt(i) + newString;
        }
    }
    
    return newString;
}

numberformat.formatDecimal = function (str)
{
    var tmpStr = numberformat.removeUntilLastDot(str);
//    tmpStr = numberformat.removeComma(tmpStr);
    tmpNumber = new Number(tmpStr).valueOf();
    tmpNumber = tmpNumber.toFixed(2);
    tmpStr = tmpNumber.toString();
//    tmpStr = numberformat.addCommas(tmpStr);
    
    return tmpStr;
}

numberformat.formatInteger = function (str)
{
    var tmpStr = numberformat.removeUntilLastDot(str);
    tmpStr = numberformat.removeComma(tmpStr);
    tmpNumber = new Number(tmpStr).valueOf();
    tmpNumber = tmpNumber.toFixed(0);
    tmpStr = tmpNumber.toString();
    tmpStr = numberformat.addCommas(tmpStr);
    
    return tmpStr;
}

numberformat.formatDecimalObject = function (obj)
{
    if (commonfunction.isBlankValue(obj.value))
    {
        obj.value = '0.00';
    }
    else
    {
        obj.value = numberformat.formatDecimal(obj.value);
    }
}

numberformat.removeCommasObject = function (obj)
{
    obj.value = numberformat.removeComma(obj.value);
}

numberformat.formatIntegerObject = function (obj)
{
    if (commonfunction.isBlankValue(obj.value))
    {
        obj.value = '0';
    }
    else
    {
        obj.value = numberformat.formatInteger(obj.value);
    }
}


numberformat.keyPressIntegerAndComma = function (myfield, e, dec)
{
    var key;
    var keychar;

    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);

    if ((key==null) || (key==0) || (key==8) || 
        (key==9) || (key==13) || (key==27) )
       return true;

    else if ((("0123456789,-").indexOf(keychar) > -1))
       return true;

    else if (dec && (keychar == "."))
    {
    myfield.form.elements[dec].focus();
    return false;
    }
    else return false;
}
/*==========================================================================# 
# * Function for adding a Filter to an Input Field                          # 
# * @param  : [filterType  ] Type of filter 0=>Alpha, 1=>Num, 2=>AlphaNum   # 
# * @param  : [evt         ] The Event Object                               # 
# * @param  : [allowDecimal] To allow Decimal Point set this to true        # 
# * @param  : [allowCustom ] Custom Characters that are to be allowed       # 
#==========================================================================*/
function filterInput(filterType, evt, allowDecimal, allowCustom){ 
    var keyCode, Char, inputField, filter = ''; 
    var alpha = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    var num   = '0123456789'; 
    // Get the Key Code of the Key pressed if possible else - allow 
    if(window.event){ 
        keyCode = window.event.keyCode; 
        evt = window.event; 
    }else if (evt)keyCode = evt.which; 
    else return true; 
    // Setup the allowed Character Set 
    if(filterType == 0) filter = alpha; 
    else if(filterType == 1) filter = num; 
    else if(filterType == 2) filter = alpha + num; 
    if(allowCustom)filter += allowCustom; 
    if(filter == '')return true; 
    // Get the Element that triggered the Event 
    inputField = evt.srcElement ? evt.srcElement : evt.target || evt.currentTarget; 
    // If the Key Pressed is a CTRL key like Esc, Enter etc - allow 
    if((keyCode==null) || (keyCode==0) || (keyCode==8) || (keyCode==9) || (keyCode==13) || (keyCode==27) )return true; 
    // Get the Pressed Character 
    Char = String.fromCharCode(keyCode); 
    // If the Character is a number - allow 
    if((filter.indexOf(Char) > -1)) return true; 
    // Else if Decimal Point is allowed and the Character is '.' - allow 
    else if(filterType == 1 && allowDecimal && (Char == '.') && inputField.value.indexOf('.') == -1)return true; 
    else return false; 
}