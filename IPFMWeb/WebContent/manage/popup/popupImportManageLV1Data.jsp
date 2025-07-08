<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<script language="javascript">
</script>

<style type="text/css">
	.col1 {width:25%; text-align:right;}
	.col2 {width:75%;}
	.colright {text-align:right;}
	.vTop {height:100%; vertical-align:top;}
</style>

<f:subview id="popupModalSubview"> 
<rich:modalPanel id="importData" autosized="true" 
	styleClass="contentform" height="250" minWidth="600" label="Find Region">
	<f:facet name="header">
		<h:panelGroup>
			<img src="../images/ico_member.gif" alt="" width="23" height="15" /> 
			<strong class="ms10w"><span class="style9">Import Data</span></strong>
		</h:panelGroup>	
	</f:facet>
	
	<f:facet name="controls">
    	<h:panelGroup>
        	<h:graphicImage value="../images/close.png" styleClass="hidelink" id="hidelink"/>
            <rich:componentControl for="importData" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
	
	<a4j:form id="errorMsgRegionMultiQuery">
		<h:messages styleClass="contentlabelform" errorStyle="color: red" warnStyle="color: green" infoStyle="color: blue" />	
	</a4j:form>
					
	<a4j:form id="formRegionMultiQuery">
		<rich:panel id="panel1">	
			<h:panelGroup id="group0" style="width:100%" rendered="#{rangeIPBean.importError == '0'}">
			<table width="97%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:panelGrid  border="0" width="100%" columns="2" styleClass="contentlabelform" columnClasses="col1,col2">
							<h:panelGroup styleClass="vTop">
								<h:panelGrid columns="3" cellpadding="0" cellspacing="0" rowClasses="vTop" styleClass="vTop">
									<h:outputText value="Import File (Excel) " style="width:100%; font-weight: bolder;" />
									<h:graphicImage value="../images/icon_required.gif" style="border:0" />
									<h:outputText value=" : " style="width:100%; font-weight: bolder;" />
								</h:panelGrid>
							</h:panelGroup>
							<h:panelGroup styleClass="vTop">
								<rich:fileUpload fileUploadListener="#{systemParameterAction.listener}"
	             							maxFilesQuantity="#{systemParameterFileUploadBean.uploadsAvailable}"
	             							id="upload" 
	             							immediateUpload="#{systemParameterFileUploadBean.autoUpload}"
	             							acceptedTypes="#{systemParameterFileUploadBean.acceptedTypes}" 
	             							allowFlash="#{systemParameterFileUploadBean.useFlash}"
											sizeErrorLabel="File Size Over!" 
	             							sizeErrorLabelClass="contentform"
	             							uploadListClass="contentform"
	             							transferErrorLabelClass="contentform"
	             							styleClass="contentform"
	             							fileEntryClass="contentform"
	             							fileEntryControlClass="contentform"
	             							progressLabelClass="contentform"
	             							addButtonClass="contentform"
	             							uploadButtonClass="contentform"
	             							listHeight="70" autoclear="true"
	             							listWidth="100%" onuploadcomplete="fireClickEvent(document.getElementById('popupModalSubview:formRegionMultiQuery:ImportForm:btnSubmitUpload'));" >
	             							<a4j:support event="onuploadcomplete"  reRender="groupImportCommand" />
	         							</rich:fileUpload>
      							</h:panelGroup>
						</h:panelGrid>
						<h:panelGrid id="groupImportCommand" width="100%" border="0" columns="3" styleClass="contentlabelform" style="text-align:right;" >
							<a4j:commandButton id="btnSubmitUpload" styleClass="rich-button" value="Submit" action="#{rangeIPAction.importData}" reRender="panel1">
								<a4j:actionparam assignTo="#{rangeIPBean.importError}" value="1"></a4j:actionparam>
          					</a4j:commandButton>
          					<a4j:commandButton id="btnSubmitUpload1" styleClass="rich-button" value="Submit" action="#{rangeIPAction.importData1}" reRender="panel1">
								<a4j:actionparam assignTo="#{rangeIPBean.importError}" value="2"></a4j:actionparam>
          					</a4j:commandButton>
							<h:commandButton id="btnCancelUpload" styleClass="rich-button" value="Cancel" 
	          					action="#{systemParameterAction.cancel}" />
	          				
						</h:panelGrid>
					</td>
				</tr>
			</table>
			</h:panelGroup>
			<h:panelGroup id="group1" style="width:100%" rendered="#{rangeIPBean.importError == '1'}">
					<h:panelGrid id="groupImportFile" border="0" width="100%" columns="1" styleClass="contentlabelform"  style="text-align:center;">
						<h:panelGroup styleClass="vTop" style="text-align:center;">
							<h:outputText value="Import Data Success." style="width:100%; font-weight: bolder;" />
						</h:panelGroup>
						<rich:spacer height="5" />
						<div align="right" > 
							<a4j:commandButton value="Cancel" styleClass="rich-button"  immediate="true" >
								<rich:componentControl for="importData" operation="hide" event="onclick" />
							</a4j:commandButton>
						</div>	
					</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup id="group2" style="width:100%" rendered="#{rangeIPBean.importError == '2'}">
					<h:panelGrid id="groupImportFile1" border="0" width="100%" columns="1" styleClass="contentlabelform" >
						<h:panelGroup styleClass="vTop" style="text-align:center;">
							<h:outputText value="Import Data Fail." style="width:100%; font-weight: bolder;" />
						</h:panelGroup>
						<h:panelGroup id="tableRole" style="width:100%; ext-align:center;">
							<rich:dataTable width="100%" id="ipDetailTable" cellpadding="1" cellspacing="0" border="0"
										var="ipDetail" value="#{rangeIPBean.tempList}" reRender="scrollIPDetailTable" rows="5"
										rowClasses="odd,even" 
										styleClass="contentform" rowKeyVar="index" 
										headerClass="tableHeader">
	
								<rich:column styleClass="valignTop" width="30%">
									<f:facet name="header">
										<h:outputText value="Row No." escape="false" styleClass="contentform tableHeaderText"></h:outputText>
									</f:facet>
									<div align="left">
		          						<h:outputText value="#{ipDetail.str1}" escape="false" styleClass="contentform">
		          						</h:outputText>
									</div>
								</rich:column>
								<rich:column styleClass="valignTop"  width="70%">
									<f:facet name="header">
										<h:outputText value="Error" escape="false" styleClass="contentform tableHeaderText"></h:outputText>
									</f:facet>
									<div align="left">
		          						<h:outputText value="#{ipDetail.str2}" escape="false" styleClass="contentform">
		          						</h:outputText>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="1">
											<h:graphicImage value="../images/document_letter_download.png"></h:graphicImage>
											Total : <h:outputText value="#{fn:length(rangeIPBean.tempList)}" /> records
										</rich:column>
										<rich:column colspan="1">
											<rich:datascroller immediate="true" rendered="true" align="right" for="ipDetailTable"
												maxPages="#{ipfmConfigBean.maxPage}" id="scrollIPDetailTable" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												fastStep="#{ipfmConfigBean.fastStepPage}" style="background-color: #cccccc;"/>
										</rich:column>
									</rich:columnGroup>					
								</f:facet>
							</rich:dataTable>
							<rich:spacer height="5" />
							<div align="right" > 
								<a4j:commandButton value="Cancel" styleClass="rich-button"  immediate="true" >
									<rich:componentControl for="importData" operation="hide" event="onclick" />
								</a4j:commandButton>
							</div>		
					 </h:panelGroup>
					</h:panelGrid>
			</h:panelGroup>
		</rich:panel>
	</a4j:form>
					
	
</rich:modalPanel>
</f:subview>
