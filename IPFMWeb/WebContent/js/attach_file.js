	var http_request;
	function initAjax(){
		if (window.XMLHttpRequest){
			http_request = new XMLHttpRequest();
		} else if (window.ActiveXObject){
			http_request = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	
	function attachFile(obj){
		var filename = obj.value;
		var pos = filename.lastIndexOf(".");
		var fileExecpt = ".doc;.docx;.xls;.xlsx;.vsd;.jpg;.gif;.svg;.zip;.rar;.7z;";
		var filenameTmp = '';
		var filenameL = filename.split('\\');
		if(filenameL.length > 0){
			filenameTmp = filenameL[filenameL.length - 1];
		}else{
			filenameTmp = filename;
		}
		
		var rex = /^[A-Za-z0-9.() _-]*$/;
		if(fileExecpt.indexOf(filename.substring(pos)+";")<0){
			showErrorDlg("ER0033");
		}else if(!rex.test(filenameTmp)){
			showErrorDlg("ER0214");
		}else {
			var frmUpload = document.getElementById("uploadFileForm");
			
			var urNo = document.getElementById("urNo").value;
			if(urNo == 'DetailForm:urNo'){
				var getUrNo = document.getElementById(urNo).value;
				document.getElementById("urNo").value=getUrNo;
			}
								
			var userName = document.getElementById("userName").value;
			if(userName == 'DetailForm:userName'){
				var getUserName = document.getElementById(userName).value;
				document.getElementById("userName").value=getUserName;
			}
			
			if(document.getElementById("urStatus") != null){
				var urStatus = document.getElementById("urStatus").value;
//				var getUrStatus = document.getElementById(urStatus).value;
//				document.getElementById("urStatus").value=getUrStatus;
			}
			
			
			var isAttach = document.getElementById("isAttach").value;
			
			frmUpload.appendChild(obj);
			try{
				frmUpload.submit();
				document.getElementById(isAttach).value="Y";
			}catch (ex){
				alert(ex.message);
			}
			var fileInput = document.getElementById("fileInput");
			fileInput.appendChild(obj);
			frmUpload.reset();			
		}
		//document.getElementById("attachFileIndex").form.reset();
		var elem = document.getElementById("attachFileIndex");
        elem.parentNode.innerHTML = elem.parentNode.innerHTML;
	}
	function attachFileIndex(obj,index){
		
		var filename = obj.value;
		var pos = filename.lastIndexOf(".");
		var fileExecpt = ".doc;.docx;.xls;.xlsx;.vsd;.jpg;.gif;.svg;.zip;.rar;.7z;";
		if(fileExecpt.indexOf(filename.substring(pos)+";")<0){
			showErrorDlg1("ER0033");
		} else {
			var uploadFileform = "uploadFileForm"+index;
			var isAttachStr = "isAttach"+index;
			var fileInputStr = "fileInput"+index;
			var urNoStr = "DetailForm:urNo"+index;
			
			
			if(urNoStr == 'DetailForm:urNo'+index){
				var getUrNo = document.getElementById(urNoStr).value;
				document.getElementById("urNo"+index).value=getUrNo;
			}
			
					
			var userName = document.getElementById("userName"+index).value;
			if(userName == ('DetailForm:userName'+index)){
				var getUserName = document.getElementById(userName).value;
				document.getElementById("userName"+index).value=getUserName;
			}

			
//			
//			var userNameStr = "userName"+index;
			var frmUpload = document.getElementById(uploadFileform);
//			var urNo = document.getElementById(urNoStr).value;
//			var getUrNo = document.getElementById(urNo).value;
//			document.getElementById(urNoStr).value=getUrNo;
//			var userName = document.getElementById(userNameStr).value;
//			var getUserName = document.getElementById(userName).value;
//			document.getElementById(userNameStr).value=getUserName;
			
			var isAttach = document.getElementById(isAttachStr).value;
			frmUpload.appendChild(obj);
			try{
				frmUpload.submit();
				document.getElementById(isAttach).value="Y";
			}catch (ex){
				alert(ex.message);
			}
			var fileInput = document.getElementById(fileInputStr);
			fileInput.appendChild(obj);
			frmUpload.reset();		
		}
		var elem = document.getElementById("attachFileIndex"+index);
        elem.parentNode.innerHTML = elem.parentNode.innerHTML;

		//document.getElementById("attachFileIndex"+index).form.reset();	
	}
	function deleteFile(urNo,seq){
		document.getElementById("deleteURNo").value=urNo;
		document.getElementById("deleteSeq").value=seq;
		
		Richfaces.showModalPanel('confirmDlg');
	}
	
	function deleteFileIndex(urNo,seq,index){
		
		var deleteURNoStr = "deleteURNo"+index;
		var deleteSeqStr = "deleteSeq"+index;
		var confirmDlgStr = "confirmDlg"+index;

		document.getElementById(deleteURNoStr).value=urNo;
		document.getElementById(deleteSeqStr).value=seq;
		Richfaces.showModalPanel(confirmDlgStr);
	}
	
	function deleteConfirm(){
		var urNo = document.getElementById("deleteURNo").value;
		var seq  = document.getElementById("deleteSeq").value;
		deleteAttachFile(urNo,seq);
	}
	
	function deleteConfirmIndex(category,index){
		var urNo = document.getElementById("deleteURNo"+index).value;
		var seq  = document.getElementById("deleteSeq"+index).value;
		if (index==1) deleteAttachFile1(urNo,category,seq);
		else if (index==2) deleteAttachFile2(urNo,category,seq);
	}
	
	function requestdone(){
		alert("done");
	}
	
	String.prototype.trim = function() {
			return this.replace(/^\s+|\s+$/g,"");
	}
	
	function findByName(params,indexStr){
		var key=(indexStr+"=");
		var subParam=params.substr(params.indexOf(key)+key.length);
		return (subParam.indexOf("&")>0)?subParam.substr(0,subParam.indexOf("&")):subParam; 
	}
	
	function getFileName(filename){
		filename = filename.replace(/\\/g,'/');
		return filename.substr(filename.lastIndexOf("/")+1);
	}
	
	function successUpload(urNo){
		//alert('successUpload urNo = '+urNo);
		renderAttachTable(urNo);
	}
	
	function successUploadIndex(urNo,category,index){
		//alert('successUpload urNo = '+urNo+' index = '+index);
		if (index==1) {
			renderAttachTable1(urNo,category);
		}else if (index==2) {
			renderAttachTable2(urNo,category);
		}else{
			renderAttachTable(urNo);
		}
	}
	
	function failedUpload(){
		Richfaces.showModalPanel('errorFileAttach');
	}
	
	function duplicateFile(){
		showDuplicateFile("ER0064");
	}

