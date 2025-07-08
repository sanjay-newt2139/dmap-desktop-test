<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<rich:panel>
<table width="1056" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="1056" height="321" background="../images/UserReqIP.jpg"><table width="103%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="10" rowspan="10" align="left" valign="top"><img src="../images/h321.jpg" width="6" height="321" /></td>
        <td width="16" height="70">&nbsp;</td>
        <td width="110">&nbsp;</td>
        <td colspan="2" rowspan="2" align="left" valign="bottom"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="81%"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="19%" align="center"><label>
                    <input type="checkbox" name="checkbox3" id="checkbox3" />
                  </label></td>
                  <td width="81%">OLA
                    <label>
                      <input type="text" name="textfield2" id="textfield2" style="width:50px" />
                    </label></td>
                </tr>
                <tr>
                  <td align="center"><label>
                    <input type="checkbox" name="checkbox" id="checkbox4" />
                  </label></td>
                  <td>Sendmail</td>
                </tr>
              </table>
                <label></label></td>
          </tr>
        </table>        </td>
        <td width="34">&nbsp;</td>
        <td colspan="3" valign="bottom"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="6%" align="center"><label>
              <input type="checkbox" name="checkbox4" id="checkbox5" />
            </label></td>
            <td width="81%">OLA
              <label>
                <input type="text" name="textfield3" id="textfield3" style="width:50px" />
              </label></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="center"><label>
              <input type="checkbox" name="checkbox4" id="checkbox6" />
            </label></td>
            <td>Sendmail</td>
          </tr>
        </table></td>
        <td width="448">&nbsp;</td>
      </tr>
      <tr>
        <td height="22">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td width="155" rowspan="3" align="center" valign="top">
	        <a4j:commandLink id="showPanel1" actionListener="#{wfUserAction.showUser}" 
					reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
				<img src="../images/blankReq01.png" alt="1" width="160" height="137" border="0" />
				<f:param name="header" value="Tier 1"/>
			</a4j:commandLink>
        
        </td>
        <td width="26">&nbsp;</td>
        <td width="131">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="92">&nbsp;</td>
        <td>
        	<a4j:commandLink id="showPanel2" actionListener="#{wfUserAction.showUser}" 
					reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
				<img src="../images/blankReq01.png" alt="1" width="107" height="75" border="0" />
				<f:param name="header" value="Requester"/>
			</a4j:commandLink>
        </td>
        <td colspan="3" valign="bottom"><table width="100%" border="0" >
          <tr>
            <td width="25%">&nbsp;</td>
            <td width="20%" align="right"><label>
              <input type="checkbox" name="checkbox2" id="checkbox" />
            </label></td>
            <td width="55%">OLA
              <label>
                <input type="text" name="textfield" id="textfield" style="width:50px" />
              </label></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="right"><label>
              <input type="checkbox" name="checkbox2" id="checkbox2" />
            </label></td>
            <td>Sendmail</td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="21">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2" rowspan="2">
			&nbsp;
<!-- 		        
        	<a4j:commandLink id="showPanel3" actionListener="#{wfUserAction.showUser}" 
					reRender="WFUserRequestPopup" oncomplete="Richfaces.showModalPanel('WFUserRequestPopup')">
				<img src="../images/blankReq01.png" alt="1" width="100" height="75" border="0" />
				<f:param name="header" value="Manager"/>
			</a4j:commandLink>
-->
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="64">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="32">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="14">&nbsp;</td>
        <td width="112">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      
    </table></td>
  </tr>
  <tr>
  	<td>Note : Click Role(Node) for View User In Role</td>
  </tr>
</table>
</rich:panel>