<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<rich:panel>
<table id="Table_01" width="1057" height="321" border="0" cellpadding="0" cellspacing="0">
<tr>
		<td rowspan="7">
			<img src="../images/requestIP_01.jpg" width="27" height="321" alt=""></td>
		<td rowspan="2">
			<img src="../images/requestIP_02.jpg" width="108" height="98" alt=""></td>
		<td height="98" colspan="3" rowspan="2" valign="bottom" background="../images/requestIP_03.jpg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="19%" align="center"><label>
              <input type="checkbox" name="checkbox3" id="checkbox3">
            </label></td>
            <td width="81%">OLA
              <label>
                <input type="text" name="textfield2" id="textfield2" style="width:50px">
              </label></td>
          </tr>
          <tr>
            <td align="center"><label>
              <input type="checkbox" name="checkbox3" id="checkbox4">
            </label></td>
            <td>Sendmail</td>
          </tr>
        </table></td>
<td height="68" colspan="2" valign="bottom" background="../images/requestIP_04.jpg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="4%">&nbsp;</td>
    <td width="3%" align="center"><label>
      <input type="checkbox" name="checkbox4" id="checkbox5">
    </label></td>
    <td width="93%">OLA
      <label>
        <input type="text" name="textfield3" id="textfield3" style="width:50px">
      </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center"><label>
      <input type="checkbox" name="checkbox4" id="checkbox6">
    </label></td>
    <td>Sendmail</td>
  </tr>
</table></td>
<td>
			<img src="../images/spacer.gif" width="1" height="68" alt=""></td>
	</tr>
	<tr>
		<td rowspan="4">
			<a4j:commandLink id="showPanel1" actionListener="#{wfUserAction.showUser}" 
				reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
			<img src="../images/requestIP_05.jpg" width="157" height="136" alt="" border="0">
			<f:param name="header" value="Planing"/>
		</a4j:commandLink>
		</td>
		<td rowspan="6">
			<img src="../images/requestIP_06.jpg" width="601" height="253" alt=""></td>
		<td>
			<img src="../images/spacer.gif" width="1" height="30" alt=""></td>
	</tr>
	<tr>
		<td><a4j:commandLink id="showPanel2" actionListener="#{wfUserAction.showUser}" 
				reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
			<img src="../images/requestIP_07.jpg" width="108" height="76" border="0">
			<f:param name="header" value="Requester"/>
		</a4j:commandLink></td>	
		<td rowspan="5">
			<img src="../images/requestIP_08.jpg" width="22" height="223" alt=""></td>
		<td height="93" colspan="2" rowspan="2" valign="bottom" background="../images/requestIP_09.jpg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="23%">&nbsp;</td>
            <td width="15%" align="center"><label>
              <input type="checkbox" name="checkbox" id="checkbox">
            </label></td>
            <td width="62%">OLA
              <label>
              <input type="text" name="textfield" id="textfield" style="width:50px">
            </label></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="center"><label>
              <input type="checkbox" name="checkbox2" id="checkbox2">
            </label></td>
            <td>Sendmail</td>
          </tr>
        </table></td>
<td>
			<img src="../images/spacer.gif" width="1" height="76" alt=""></td>
	</tr>
	<tr>
		<td rowspan="4">
			<img src="../images/requestIP_10.jpg" width="108" height="147" alt=""></td>
		<td>
			<img src="../images/spacer.gif" width="1" height="17" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<a4j:commandLink id="showPanel3" actionListener="#{wfUserAction.showUser}" 
				reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
			<img src="../images/requestIP_11.jpg" width="101" height="75" border="0" alt="">
			<f:param name="header" value="Manager"/>
		</a4j:commandLink>
		</td>
		<td rowspan="3">
			<img src="../images/requestIP_12.jpg" width="40" height="130" alt=""></td>
		<td>
			<img src="../images/spacer.gif" width="1" height="13" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="../images/requestIP_13.jpg" width="157" height="117" alt=""></td>
		<td>
			<img src="../images/spacer.gif" width="1" height="62" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="../images/requestIP_14.jpg" width="101" height="55" alt=""></td>
		<td>
			<img src="../images/spacer.gif" width="1" height="55" alt=""></td>
	</tr>
</table>
</rich:panel>