<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<html>
<head>
<title>IP Flow Management</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="../js/common.js"></script>


<script type="text/javascript">
	function downloadManual(){
		document.getElementById('tree:manualDownload').click();
	}
</script>
<style type="text/css">
	.rich-tree-node-selected{background:transparent;}
	.rich-tree-node-highlighted{background:transparent;}
</style>
</head>
<body style="margin:0 0">
<f:view>

<h:form id="tree">

<a4j:poll enabled="true" reRender="gridTree" interval="#{ipfmConfigBean.treesMsTime}" ></a4j:poll>
<table width="250" border="0" cellspacing="0" cellpadding="0" background="../images/b_bg.jpg">
  	<tr>
    	<td background="../images/b_bg.jpg">
    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
      			<tr>
        			<td width="100%" align="center" valign="middle" class="ms10w">
        				<table width="100%" border="0" cellpadding="0" cellspacing="1">
            				<tr>
              					<td height="40" align="left" background="../images/bg_m2.jpg"><rich:spacer width="2" />
              						<h:commandLink styleClass="tree_link" action="#{userProfileAction.init}" target="body" disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/contact_blue.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>User Profile</strong></span>
	              						<f:param name="programIDParam" value="ISSMS007"></f:param>
              						</h:commandLink><br/><rich:spacer width="3" />
              						<h:commandLink id="manualDownload" rendered="true" action="#{params.getManualDownloadURL}" styleClass="tree_link"  disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/folder2.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>IPFM User Manual</strong></span>
	              					</h:commandLink><br/><rich:spacer width="3" />           				
	              					<!--<h:commandLink id="manualDownload2" rendered="true" action="#{params.getManualDownloadURL2}" styleClass="tree_link"  disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/folder2.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>IPFM User Manual2</strong></span>
	              					</h:commandLink> -->
	              					<h:commandLink id="traningDoc" rendered="true" action="#{params.getDownloadIPFMtraining}" styleClass="tree_link"  disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/folder2.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>IPFM Training</strong></span>
	              					</h:commandLink><br/><rich:spacer width="3" />  
	              					<h:commandLink id="urStatus" rendered="true" action="#{params.getDownloadURStatus}" styleClass="tree_link"  disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/folder2.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>ตรวจสอบสถานะของ UR</strong></span>
	              					</h:commandLink><br/><rich:spacer width="3" /> 
	              					<h:commandLink id="requestNw" rendered="true" action="#{params.getDownloadNWRequest}" styleClass="tree_link"  disabled="#{userSession.newUser=='Y'}">
	              						<img src="../images/folder2.png" width="11" height="9" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>การขอ  Network Configuration</strong></span>
	              					</h:commandLink> 
	              					
              					</td>
              				</tr>
        				</table>
        			</td>
      			</tr>
      			<tr>
        			<td width="100%" align="center" valign="middle" class="ms10w">
        				<table width="100%" border="0" cellpadding="0" cellspacing="1">
            				<tr>
              					<td height="20" align="left" bgcolor="#F9F9F9" ><rich:spacer width="2" />
              						<a4j:commandLink id="refreshButton" styleClass="tree_link" disabled="#{userSession.newUser=='Y'}" reRender="gridTree" >
	              						<img src="../images/refresh.png" width="14" height="14" border="0">&nbsp;
	              						<span class="thtext_color contentform"><strong>Refresh Tree</strong></span>
              						</a4j:commandLink>
              					</td>
              				</tr>
        				</table>
        			</td>
      			</tr>		
      			<tr>
        			<td width="100%" align="left" valign="top" class="thtext_user">
        				<h:panelGroup id="gridTree" >
        				<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" bgcolor="#000000" >
            				<tr>
              					<td bgcolor="#f1f1f1">
									<rich:tree value="#{tDL.data}" adviseNodeOpened="#{tDL.nodeOpened}" var="item" nodeFace="#{item.type}" switchType="client"  > 
							            <rich:treeNode type="tdlRoot" >
								            <f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <h:commandLink action="#{inboxAction.showInbox}" title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link"  disabled="#{userSession.newUser=='Y' || item.counter==0}">
								            	<f:param name="treeType" value="TODOLIST" />
								            	<f:param name="treeLevel" value="1" />
								            </h:commandLink>
							            </rich:treeNode>
							            <rich:treeNode type="tdlType" >
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8"  style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8"  style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y'}" style="color:orange;">
								            	<f:param name="treeType" value="TODOLIST" />
								            	<f:param name="treeLevel" value="2" />
								            	<f:param name="urType" value="#{item.urType}" />
											</h:commandLink>
							            </rich:treeNode>
							            <rich:treeNode type="tdlStatus">
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/page.gif" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/page.gif" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
							            	<h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y'}">
												<f:param name="treeType" value="TODOLIST" />
												<f:param name="treeLevel" value="3" />
												<f:param name="urType" value="#{item.urType}" />
												<f:param name="actionCode" value="#{item.action}" />
											</h:commandLink>
							            </rich:treeNode>
							        </rich:tree>	
                 				</td>
              				</tr>
            				<tr>
              					<td bgcolor="#f1f1f1">
 									<rich:tree value="#{wL.data}" adviseNodeOpened="#{wL.nodeOpened}" var="item" nodeFace="#{item.type}" switchType="client">
							            <rich:treeNode type="tdlRoot" >
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y' || item.counter==0}" >
								           		<f:param name="treeType" value="WATCHLIST" />
								           		<f:param name="treeLevel" value="1" />
												<f:setPropertyActionListener target="#{headMenuAction.actionName}" value="#{item.action}" />
											</h:commandLink>
							            </rich:treeNode>
							            <rich:treeNode type="tdlType" >
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
							                <h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y'}" style="color:blue;">
							                	<f:param name="treeType" value="WATCHLIST" />
							                	<f:param name="treeLevel" value="2" />
							                	<f:param name="urType" value="#{item.urType}" />
											</h:commandLink>
							            </rich:treeNode>
							        </rich:tree>	
                 				</td>
              				</tr> 
              				<h:panelGroup rendered="#{userSession.roleMonitor}" >
              				<tr>
              					<td bgcolor="#f1f1f1">
 								    <rich:tree value="#{monitor.data}" adviseNodeOpened="#{monitor.nodeOpened}" var="item" nodeFace="#{item.type}" switchType="client">
							            <rich:treeNode type="tdlRoot" >
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y' || item.counter==0}" >
								            	<f:param name="treeType" value="MONITORLIST" />
								            	<f:param name="treeLevel" value="1" />
											</h:commandLink>
							            </rich:treeNode>
							            <rich:treeNode type="tdlType" >
							            	<f:facet name="iconLeaf">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <f:facet name="icon">
								            	<h:graphicImage value="../images/arrow_g.png" width="5" height="8" style="vertical-align:middle;"></h:graphicImage>
								            </f:facet>
								            <h:commandLink action="#{inboxAction.showInbox}"  title="#{item.title}" value="#{item.title}" target="body" styleClass="tree_link" disabled="#{userSession.newUser=='Y'}" style="color:blue;">
								            	<f:param name="treeType" value="MONITOR" />
								            	<f:param name="treeLevel" value="2" />
								            	<f:param name="urType" value="#{item.urType}" />
											</h:commandLink>
							            </rich:treeNode>
							        </rich:tree>		
                 				</td>
              				</tr>  
              				</h:panelGroup>       		             				
          				</table>
          				</h:panelGroup>
          			</td>
          		</tr>
          	</table>
		</td>
	</tr>
</table>
</h:form>
</f:view>
</body>
</html>