<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<style type="text/css">
	.rich-filter-input {width:80px;}
</style>

<script language="javascript">
</script>
 
<f:subview id="popupModalSubview"> 
<rich:modalPanel id="popupAddUser" autosized="true"
	styleClass="contentform" height="300" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Add User</span></strong>
		</h:panelGroup>	
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="popupAddUser" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel>	
			<table width="97%" border="0" cellpadding="0" cellspacing="0"class="thtext_detail">
				<tr>
					<td width="40%"><rich:spacer height="0"/></td>
					<td width="60%"><rich:spacer height="0"/></td>
				</tr>
				<tr>
					<td align="right"><h:outputText value="Add User" styleClass="label"/></td>
					<td>
						<rich:spacer width="5"></rich:spacer>
						<h:outputText value="Role Requester" />
					</td>
				</tr>
				<tr>
					<td align="right"><h:outputText value="User ID/User Name" styleClass="label"/></td>
					<td>
						<rich:spacer width="5"></rich:spacer>
						<h:inputText value="Sukmak" size="20"/>
						<rich:spacer width="5"></rich:spacer>
						<a4j:commandButton value="search" styleClass="rich-botton"></a4j:commandButton>
						<rich:spacer width="5"></rich:spacer>
						<a4j:commandButton value="Reset" styleClass="rich-botton"></a4j:commandButton>
					</td>
				</tr>
				<tr><td><rich:spacer height="10" /></td></tr>
				<tr>
					<td colspan="2">
						<h:panelGroup id="tableRole" style="width:100%">
							<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
								var="detail" value="#{userProfileBean.userList}" reRender="scrollIPDetailTable" rows="5"
								  
								 
								rowClasses="odd,even" 
								styleClass="contentform" rowKeyVar="index" 
								headerClass="tableHeader">

								<rich:column styleClass="valignTop">
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="contentform tableHeaderText"></h:outputText>
									</f:facet>
									 <div align="center">
									 	<h:selectBooleanCheckbox  value="#{userProfileBean.rowCheck}">

								    	</h:selectBooleanCheckbox>
		          					</div>
								</rich:column>
								<rich:column  filterValue="#{userProfileBean.filterPopupAddUser.filterColumn1}"  filterExpression="#{fn:containsIgnoreCase(detail.userName,userProfileBean.filterPopupAddUser.filterColumn1)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sortPopupAddUser.sortColumn1}" sortBy="#{detail.userName}">
									<f:facet name="header">
										   <h:panelGroup>
		   <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>User Name</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sortPopupAddUser.sortColumn1}" />
				<f:param name="sortColumnNo" value="1" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filterPopupAddUser.filterColumn1}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
									</f:facet>
									<div>
	          						   <h:outputText value="#{detail.userName}" styleClass="contentform"></h:outputText>
									</div>
								</rich:column>
								<rich:column  filterValue="#{userProfileBean.filterPopupAddUser.filterColumn2}"  filterExpression="#{fn:containsIgnoreCase(detail.position,userProfileBean.filterPopupAddUser.filterColumn2)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sortPopupAddUser.sortColumn2}" sortBy="#{detail.position}">
									<f:facet name="header">
										<h:panelGroup>
		   <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Position</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sortPopupAddUser.sortColumn2}" />
				<f:param name="sortColumnNo" value="2" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filterPopupAddUser.filterColumn2}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
									</f:facet>
									<div>
		          						<h:outputText value="#{detail.position}" styleClass="contentform"></h:outputText>
									</div>
								</rich:column>
								<rich:column  filterValue="#{userProfileBean.filterPopupAddUser.filterColumn3}"  filterExpression="#{fn:containsIgnoreCase(detail.dept,userProfileBean.filterPopupAddUser.filterColumn3)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sortPopupAddUser.sortColumn3}" sortBy="#{detail.dept}">
									<f:facet name="header">
											<h:panelGroup>
		 <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Department</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sortPopupAddUser.sortColumn3}" />
				<f:param name="sortColumnNo" value="3" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filterPopupAddUser.filterColumn3}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
									</f:facet>
									<div>
		          						<h:outputText value="#{detail.dept}" styleClass="contentform"></h:outputText>
									</div>
								</rich:column>
								<rich:column  filterValue="#{userProfileBean.filterPopupAddUser.filterColumn4}"  filterExpression="#{fn:containsIgnoreCase(detail.section,userProfileBean.filterPopupAddUser.filterColumn4)}"   styleClass="valignTop"  selfSorted="false" sortOrder="#{userProfileBean.sortPopupAddUser.sortColumn4}" sortBy="#{detail.section}">
									<f:facet name="header">
										<h:panelGroup>
		  <h:commandLink rendered="true" action="#{userProfileAction.indexSort}">
			 <span class="contentform tableHeaderText">
				<strong>Section</strong></span>
				<f:param name="sortColumn" value="#{userProfileBean.sortPopupAddUser.sortColumn4}" />
				<f:param name="sortColumnNo" value="4" />
				<f:param name="TablSort" value="ipDetailTable" />
		  </h:commandLink>
		 <h:inputText value="#{userProfileBean.filterPopupAddUser.filterColumn4}" style="width: 50px;">
			 <a4j:support event="onblur" reRender="ipDetailTable" />
		 </h:inputText>
	 </h:panelGroup>
									</f:facet>
									<div>
		          						<h:outputText value="#{detail.section}" styleClass="contentform"></h:outputText>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="2">
											Total : <h:outputText value="#{fn:length(userProfileBean.userList)}" /> records
										</rich:column>
										<rich:column colspan="10">
											<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
												maxPages="#{userProfileBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="hide" boundaryControls="hide" 
												style="background-color: #cccccc;"/>
										</rich:column>
									</rich:columnGroup>					
								</f:facet>
							</rich:dataTable>
							<rich:spacer height="5" />
							<div align="right" > 
								<a4j:commandButton value="Add User" styleClass="rich-button"  immediate="true" >
									<rich:componentControl for="popupAddUser" operation="hide" event="onclick" />
								</a4j:commandButton>
								<rich:spacer width="10"></rich:spacer>
								<a4j:commandButton value="Cancel" styleClass="rich-button"  immediate="true" >
									<rich:componentControl for="popupAddUser" operation="hide" event="onclick" />
								</a4j:commandButton>
							</div>		
					 </h:panelGroup>
					</td>
				</tr>
			</table>	
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
