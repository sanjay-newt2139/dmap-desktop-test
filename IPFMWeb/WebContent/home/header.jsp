<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="../js/common.js">
history.forward();
	</script>

</head>
<body style="margin: 0 0">
<f:view>
<% 
	String reqContext = request.getContextPath();
%>
<h:form>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
    		<td valign="top">
    			<table width="100%" border="0" cellpadding="0" cellspacing="0">
      				<tr>
        				<td width="236" align="center" bgcolor="#BA2415"><img src="../images/h_logo.jpg"></td>
        				<td align="right" background="../images/h_bg.jpg">
        					<table border="0" cellpadding="0" cellspacing="0" width="100%">
        					<tr>
        						<td align="center"><img src="<%= reqContext%>/LogoPictureServlet" border="0" width="140" height="70"></td>
        						<td width="177"><img src="../images/h_logo-ais.png"></td>
        					</tr>
        					</table>
        				</td>
      				</tr>
    			</table>
    		</td>
  		</tr>
	</table>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/bg_m2.jpg">
    	<tr>
			<td width="16" valign="middle">&nbsp;</td>
            	<td width="27" align="center" valign="middle">
            		<img src="../images/ic-user.gif" width="20"></td>
                <td width="401" valign="middle" >
                	<b class="thtext_th">คุณ <h:outputText value="#{userSession.ipUser.userName}" />
                	<br><span class="thtext_color">Login At <h:outputText value="#{userSession.loginDateTime}" /> น.</span></b>
                </td>
                <td width="383" align="center">             
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    	<tr>
							<td height="33">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" >
                					<tr>
										<td class="ms8"  valign="middle">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      							<tr>
							                        <td width="28" >
							                        	<img src="../images/ic-news.gif" width="28" height="25" >
							                        </td>
                        							<td width="10" valign="bottom" ></td>
							                        <td height="20" align="center" valign="middle" >
                        								<marquee behavior="scroll" scrollamount="2" scrolldelay="50" width="90%" >
                        								<nobr><font class="ms8"><h:outputText id="news" value="#{userSession.news}" /></font></nobr>
								                        </marquee>
<script language="JavaScript1.2">
var marqueewidth="550px"
	var marqueeheight="20px"
	var marqueespeed=2
	var marqueebgcolor="#CCCCCC"
	var pauseit=1

	var marqueecontent='<nobr><font class="ms8">AIS</font></nobr>'
	marqueespeed=(document.all)? marqueespeed : Math.max(1, marqueespeed-1) 
	var copyspeed=marqueespeed
	var pausespeed=(pauseit==0)? copyspeed: 0
	var iedom=document.all||document.getElementById

	if (iedom)

	document.write('<span id="temp" style="visibility:hidden;position:absolute;top:-100px;left:-9000px">'+marqueecontent+'</span>')

	var actualwidth=''

	var cross_marquee, ns_marquee



	function populate(){

	if (iedom){

	cross_marquee=document.getElementById? document.getElementById("iemarquee") : document.all.iemarquee

	cross_marquee.style.left=parseInt(marqueewidth)+8+"px"

	cross_marquee.innerHTML=marqueecontent

	actualwidth=document.all? temp.offsetWidth : document.getElementById("temp").offsetWidth

	}

	else if (document.layers){

	ns_marquee=document.ns_marquee.document.ns_marquee2

	ns_marquee.left=parseInt(marqueewidth)+8

	ns_marquee.document.write(marqueecontent)

	ns_marquee.document.close()

	actualwidth=ns_marquee.document.width

	}

	lefttime=setInterval("scrollmarquee()",20)

	}

	//window.onload=populate



	function scrollmarquee(){

	if (iedom){

	if (parseInt(cross_marquee.style.left)>(actualwidth*(-1)+8))

	cross_marquee.style.left=parseInt(cross_marquee.style.left)-copyspeed+"px"

	else

	cross_marquee.style.left=parseInt(marqueewidth)+8+"px"



	}

	else if (document.layers){

	if (ns_marquee.left>(actualwidth*(-1)+8))

	ns_marquee.left-=copyspeed

	else

	ns_marquee.left=parseInt(marqueewidth)+8

	}

	}



	if (iedom||document.layers){

	with (document){

	document.write('<table border="0" cellspacing="0" cellpadding="0"><td>')

	if (iedom){

	write('<span style="position:relative;width:'+marqueewidth+';height:'+0+';overflow:hidden">')

	write('<span style="position:absolute;width:'+marqueewidth+';height:'+marqueeheight+';" onMouseover="copyspeed=pausespeed" onMouseout="copyspeed=marqueespeed">')

	write('<span id="iemarquee" style="position:absolute;left:0px;top:0px"></span>')

	write('</span></span>')

	}

	else if (document.layers){

	write('<ilayer width='+marqueewidth+' height='+marqueeheight+' name="ns_marquee" bgColor='+marqueebgcolor+'>')

	write('<layer name="ns_marquee2" left=0 top=0 onMouseover="copyspeed=pausespeed" onMouseout="copyspeed=marqueespeed"></layer>')

	write('</ilayer>')

	}

	document.write('</td></table>')

	}

	}
</script>
														</td>
													</tr>
												</table>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
	                	<td width="200" height="33" align="right" class="ms10w" valign="bottom">
	                		<table border="0" height="30" align="right" cellpadding="0" cellspacing="0">
								<tr>
                      				<td width="80"  align="center" background="../images/b-news.png">
                      					<img src="../images/Exit.png" width="16" height="16" align="middle" > 
                      					<h:commandLink styleClass="a6" action="#{loginAction.logout}" target="_top" ><strong>Sign Out</strong></h:commandLink>
                      				</td>
                     				<td width="10"><img src="../images/blank.gif" width="10" height="10"></td>
								</tr>
								<tr>
									<td height="2" colspan="8" align="center" valign="bottom"></td>
								</tr>
			              	</table>	 
			       		</td>
              		</tr>
				</table>  		
</h:form>
</f:view>
</body>
</html>
