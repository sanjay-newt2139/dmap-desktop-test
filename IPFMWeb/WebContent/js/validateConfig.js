function numbersonly(event) {
	
	var event = event || window.event //For IE
	var key = event.which;
	//var key;
	var keychar;
	
//	if (window.event){
//	   key = window.event.keyCode;;
//	} else if(e){
//	   key = e.which;
//	} else {
//	   return true;
//	}
	
	keychar = String.fromCharCode(key);
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) || (key==17)) {
	   return true;
	} else if ((("0123456789").indexOf(keychar) > -1)) {
	   return true;
	} else if (keychar == ".") { 
	  return true;
	} else return false;
}

function numbersonlyNoDot(event) {
	var event = event || window.event //For IE
	var key = event.which;
//	var key;
	var keychar;
	
//	if (window.event){
//	   key = window.event.keyCode;;
//	} else if(e){
//	   key = e.which;
//	} else {
//	   return true;
//	}
	
	keychar = String.fromCharCode(key);
	
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) ) {
	   return true;
	} else if ((("0123456789").indexOf(keychar) > -1)) {
	   return true;
	} else return false;
}

function validatePort(obj) {
	errorString = "";
	theName = "IPaddress";
	var ipPattern = /^([ ]?[0-9]{0,4}-?[0-9]{1,4},?)*$/;          
	var val = obj.value;
	var matchPort = val.match(ipPattern);
	
	//alert(matchPort);
	if(matchPort == null) {
		alertErrorMsg("Format Input Not Collect.");
		return false;
	}
	var newString = String(matchPort);
	var splitComma = newString.split(",");
	
	if(splitComma != null) {
		for(i=0; i < splitComma.length; i++) {
			if(splitComma[i] != null || splitComma[i] != '') {
				if(parseInt(splitComma[i]) < 0) {
					alertErrorMsg('Please Specify Number Only');
					return false;
				}
			}
		}
	}

	var myNewString = newString.replace(/-/g, "|");
	var newStringComma = String(myNewString);
	var myNewPortPipeSep = newStringComma.replace(/,/g, "|");

	//alert(myNewPortPipeSep);

	var splitPortPipe = myNewPortPipeSep.split("|");
	
	if(splitPortPipe != null) {
		for(i=0; i < splitPortPipe.length; i++) {
			if(splitPortPipe[i] != null || splitPortPipe[i] != '') {
				if(splitPortPipe[i].length > 5) {
					alertErrorMsg('Port Number must not exceed 5 digit');
					return false;						
				}
				if(parseInt(splitPortPipe[i]) > 65536) {
					alertErrorMsg('Port Must Not Exceed 65536');
					return false;
				}
			}
		}
	}
	return true;
}

var alertMsgStr;

function verifyIP (IPvalue) {
	errorString = "";
	theName = "IPaddress";

	var ipPattern = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$/;
	var ipArray = IPvalue.match(ipPattern);

//	if (IPvalue == "0.0.0.0")
//	errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';

	if (ipArray == null)
	errorString =  errorString + theName + ': '+IPvalue+' is not a valid IP address.';
	else {
	for (i = 0; i < 4; i++) {
	thisSegment = ipArray[i];
	if (thisSegment > 255) {
	errorString = errorString + theName + ': '+IPvalue+' is not a valid IP address.';
	i = 4;
	}
	if ((i == 0) && (thisSegment > 255)) {
	errorString = errorString + theName + ': '+IPvalue+' is a special IP address and cannot be used here.';
	i = 4;
		  }
	   }
	}
	extensionLength = 3;
	if (errorString == "") {
		return true;
	}
	else {
		alertMsgStr= errorString;
		return false;
	}

}


function alertErrorMsg(errorString) {
		alertErrorMsgAjx(errorString);

}

function verifyTextBoxIp(obj) {
	if(!verifyIP(obj.value)) {
		obj.value="";
		alertErrorMsg(alertMsgStr);
		return false;
	} 
	return true;
} 

function checkIPKey(obj,e){
	//if(numbersonly(e)){
		if (window.event){
	   		key = window.event.keyCode;;
		} else if(e){
	   		key = e.which;
		} else {
	   		return true;
		}

		keychar = String.fromCharCode(key);
		var val = obj.value+keychar;
		if(val.indexOf("00") == 0 || val.indexOf(".") == 0 || val.indexOf("..") >= 0) {
			if(key != 8 && key != 46){
				return false;
			}
		}

		var list = val.split(".");
		var len= list.length;
		var lastNumberStr = val.substr((val.lastIndexOf(".")<0)?0:(val.lastIndexOf(".")+1));

		if(lastNumberStr == '00' ) {
			if(key != 8 && key != 46){
				return false;
			}
		}
		if (lastNumberStr.indexOf("0") == 0 && lastNumberStr.length>1) {
			if(key != 8 && key != 46){
				return false;
			}
		}

		var lastNumber = parseInt(lastNumberStr);
		
		if(lastNumber>255){
			return false; 
		} else if((len==5) && (keychar == ".")){
			return false;
		} else if(len<=5) {
			return true;
		} else{
			return false;
		}
	//} else return false;
}


function keyRange(obj,event,min,max){
//	if (window.event){
//   		key = window.event.keyCode;;
//	} else if(e){
//   		key = e.which;
//	} else {
//   		return true;
//	}
	var event = event || window.event //For IE
	key = event.which;
	
	if (obj.value.length>0 && obj.value.indexOf("0") == 0) return false;
	
	keychar = String.fromCharCode(key);
	var val = obj.value+keychar;
	var value=parseInt(val);
	if(numbersonly(event)){
		if((value<min) || (value>max)){
			return false;
		} else return true;
	} else return false;
}
function keyRangeNumber(obj,event,min,max){
	var event = event || window.event //For IE
//	if (window.event){
//   		key = window.event.keyCode;;
//	} else if(e){
//   		key = e.which;
//	} else {
//   		return true;
//	}
	key = event.which;
	keychar = String.fromCharCode(key);
	if ((("0123456789").indexOf(keychar) < 0)) {return false};
	
	if (obj.value.length>0 && obj.value.indexOf("0") == 0) return false;
	keychar = String.fromCharCode(key);
	
	var val = obj.value+keychar;
	var value=parseInt(val);

	if(numbersonly(event)){
		if((value<min) || (value>max)){
			obj.value=val.substring(0, val.length-1);
			return false;
		} else {
			return true;
		}
	} else return false;
}

function keyRangeNumberWithDot(next_ctrl,obj,event,min,max, key){
	
		var event = event || window.event //For IE
		var keyCode=event.keyCode;
		if (keyCode == 190 || keyCode == 222 || keyCode == 110){
			keyCode = 190;
		}else if (keyCode == 191 || keyCode == 111) {
			keyCode = 191;
		}
		if (keyCode == key) {  
			var _next = document.getElementById(next_ctrl) || document.getElementsByName(next_ctrl);  
			_next.focus();
	     	return false;  
		} 
		
//		
//		if (window.event){
//	   		key = window.event.keyCode;
//		} else if(event){
//	   		key = event.which;
//		} else {
//	   		return true;
//		}
		keychar = String.fromCharCode(key);
		
		if ((("0123456789").indexOf(keychar) < 0)) {return false};
		
		if (obj.value.length>0 && obj.value.indexOf("0") == 0) return false;
		keychar = String.fromCharCode(key);
		var val = obj.value;
		
		if(val.length > 3) {
			obj.value=keychar;
			val = keychar;
		}
		
		var value=parseInt(val);

		if(numbersonly(event)){
			if((value<min) || (value>max)){
				obj.value=val.substring(0, val.length-1);
				return false;
			} else return true;
		} else return false;	
}


function defaultIP(source,des){
	var ipObj1=document.getElementById(source)||document.getElementsByName(source);
	var ipObj2=document.getElementById(des)||document.getElementsByName(des);
	if ( ipObj1.value){
		var val = ipObj1.value; 
		ipObj2.value=val.substr((val.lastIndexOf(".")<0)?0:(val.lastIndexOf(".")+1));
	}
}
function checkEqValue(source,des){
	var ipObj1=document.getElementById(source)||document.getElementsByName(source);
	var ipObj2=document.getElementById(des)||document.getElementsByName(des);
	var val = ipObj1.value; 
	var sourceVal = val.substr((val.lastIndexOf(".")<0)?0:(val.lastIndexOf(".")+1));
	if (ipObj2.value==sourceVal) {
		return true;
	}
	return false;
}

function isEmptyIP(obj,chkName,textAlert){
	var ipObj=document.getElementById(chkName);
	var val = ipObj.value; 
	if(val==""){
		alertErrorMsg(textAlert);
		ipObj.focus();
	} else if(obj.value==""){
		obj.value=val.substr((val.lastIndexOf(".")<0)?0:(val.lastIndexOf(".")+1));
	}
}

function isIPLower(obj,chkName,textAlert,funct){
	var ipVal=document.getElementById(chkName).value;
	var lastNumber = parseInt(ipVal.substr((ipVal.lastIndexOf(".")<0)?0:(ipVal.lastIndexOf(".")+1)));
	var val = parseInt(obj.value);
	if(val<lastNumber){
		alertErrorMsg(textAlert);
//		obj.value="";
//		obj.value=lastNumber;
		obj.focus();
	} else {
		eval(funct);
	}
}

function isIPLowerNoFocus(obj,chkName,textAlert,funct){
	var ipVal=document.getElementById(chkName).value;
	var lastNumber = parseInt(ipVal.substr((ipVal.lastIndexOf(".")<0)?0:(ipVal.lastIndexOf(".")+1)));
	var val = parseInt(obj.value);
	if(val<lastNumber){
		alertErrorMsg(textAlert);
//		obj.value="";
//		obj.value=lastNumber;
//		obj.focus();
	} else {
		eval(funct);
	}
}


function checkAlert(chkObject,alertText){
	if(document.getElementById(chkObject).value=="0"){
		alertErrorMsg(alertText);
	}
}

function textboxToggle(item,objName){
	var chkVal=document.getElementById(objName);
	chkVal.value ='';
	chkVal.disabled = !item.checked;
	
}

function isIP(ip){
	var listVal = ip.split(".");
	if(listVal.length==4){
		return true;
	} else return false;
}

function showErrorFlag(){
	var errorFlag = document.getElementById("popupErrorDlg:formRegionMultiQuery:errorFlag").value;
	if(errorFlag) Richfaces.showModalPanel('errorDialogPopup');
}
function showModalMessage(modal){
	
	Richfaces.showModalPanel(modal);
}

function checkIPDegitKey(obj,e){
	if(digitOnly(e)){
		if (window.event){
	   		key = window.event.keyCode;;
		} else if(e){
	   		key = e.which;
		} else {
	   		return true;
		}
		
		if (obj.value.length>0 && obj.value.indexOf("0") == 0) return false;
		
		keychar = String.fromCharCode(key);
		var val = obj.value+keychar;
		
		var list = val.split(".");
		var len= list.length;
		var lastNumber = parseInt(val.substr((val.lastIndexOf(".")<0)?0:(val.lastIndexOf(".")+1)));
		
		if(lastNumber>255){
			return false; 
		} else if((len==5) && (keychar == ".")){
			return false;
		} else if(len<=5) {
			return true;
		} else return false;
	} else return false;
}
function keyDigitRange(obj,e,min,max){
	if (window.event){
   		key = window.event.keyCode;;
	} else if(e){
   		key = e.which;
	} else {
   		return true;
	}
	keychar = String.fromCharCode(key);
	var val = obj.value+keychar;
	var value=parseInt(val);
	if(digitOnly(e)){
		if((value<min) || (value>max)){
			return false;
		} else return true;
	} else return false;
}
function digitOnly(e) {
	var key;
	var keychar;
	
	if (window.event){
	   key = window.event.keyCode;;
	} else if(e){
	   key = e.which;
	} else {
	   return true;
	}
	
	keychar = String.fromCharCode(key);
	if ((key==null) || (key==0) || (key==8) ||  (key==9) || (key==13) || (key==27) ) {
	   return true;
	} else if ((("0123456789").indexOf(keychar) > -1)) {
	   return true;
	} else return false;
}

String.prototype.startsWith = function(str){
    return (this.indexOf(str) === 0);
};

String.prototype.endsWith= function(c){
    if(!c) return this.charAt(this.length - 1);
    else{
        if(typeof c== "string") c= RegExp(c + "$");
        return c.test(this);
    }
};
	
function selectAll(obj,destChk) {
	var chk = obj.checked;
	var index1st = obj.name.indexOf(":");
	var indexLast = obj.name.lastIndexOf(":");
	var formName = obj.name.substring(0,index1st);
	var CheckBoxName = obj.name.substring(0,indexLast); 
	var frm = document.getElementById(formName);
	var elmtsInput = frm.getElementsByTagName("input");
	for(var pos=0;pos<elmtsInput.length;pos++){
		if((elmtsInput[pos].name.startsWith(CheckBoxName))
			&& (elmtsInput[pos].name.endsWith(destChk))){
			elmtsInput[pos].checked = chk;
		}
	} 
}

function chkLength(obj,len){
	return (obj.value.length<len);
}

function isNumber(obj){
	var keyChar = "";
	for (var i=0; i<obj.value.length;i++) {
		keyChar = obj.value.substring(i, i+1);
		if (("0123456789").indexOf(keyChar) == -1) {
			alertErrorMsg("กรุณาป้อนข้อมูลเป็นตัวเลข");
			obj.value="";
			obj.focus();
			return "";
		}
	}
	return obj.value;
}
function isNumberIP(obj,message){
	var keyChar = "";
	if (!validateNumberIP(obj.value)) {
		alertErrorMsg(message+" รูปแบบไม่ถูกต้อง โดยค่าต้องประกอบไปด้วยตัวเลข 0-255 จำนวน 4 ชุด EX : 255.255.255.255, 255.10.0.20");		
		obj.focus();
		return "";
	}
	for (var i=0; i<obj.value.length;i++) {
		keyChar = obj.value.substring(i, i+1);
		if (("0123456789.").indexOf(keyChar) == -1) {
			alertErrorMsg("กรุณาป้อนข้อมูลเป็นตัวเลข");
			obj.focus();
			return "";
		}
	}
	return obj.value;
}
function validateNumberIP(value){
	if (value.length>0) { 
		var ip = value.split(".");
		if (ip.length != 4) {
			return false;
		}else{
			for (var i=0; i<4;i++) {
				if (ip[i]=="" || ip[i]>255 || ip[i]<0) {
					return false;
				}
			}
		}
	}
	return true;
}




