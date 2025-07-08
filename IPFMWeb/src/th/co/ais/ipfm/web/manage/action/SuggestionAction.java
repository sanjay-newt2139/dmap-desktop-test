package th.co.ais.ipfm.web.manage.action;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.ipfm.domain.Suggestion;
import th.co.ais.ipfm.service.CommonService;
import th.co.ais.ipfm.service.MainMenuService;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class SuggestionAction {
	public SuggestionAction(){
	}
	
	
	public List<Suggestion> getList(Object suggest) {
        String ref = (String)suggest;
        CommonService commond = (CommonService)JSFServiceFinderUtil.getInstance().getBean("commonService");
        return commond.findSuggestion("LOCATION", ref);
    }
	
	
}
