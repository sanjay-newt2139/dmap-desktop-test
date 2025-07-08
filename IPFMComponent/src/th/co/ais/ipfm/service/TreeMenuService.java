package th.co.ais.ipfm.service;

import java.util.ArrayList;

import th.co.ais.ipfm.domain.TreeMenu;

public interface TreeMenuService {
	public ArrayList<TreeMenu> getToDoListByUser(String userName);
	public ArrayList<TreeMenu> getWatchListByUser(String userName);
	public ArrayList<TreeMenu> getMornitorListByUser(String userName);
}
